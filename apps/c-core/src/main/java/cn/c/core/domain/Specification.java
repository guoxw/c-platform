package cn.c.core.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class Specification<T extends IdEntity> implements org.springframework.data.jpa.domain.Specification<T> {
	private String[] searchFields;
	private String[] keywords;
	private AccurateSearch[] accurateSearchs;
	private Object[] args;
	
	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public Specification(String[] searchFields, String[] keywords) {
		this.searchFields = searchFields;
		this.keywords = keywords;
		this.accurateSearchs = new AccurateSearch[]{};
	}
	
	public Specification(String[] searchFields, String[] keywords, AccurateSearch[] accurateSearchs) {
		this.searchFields = searchFields;
		this.keywords = keywords;
		this.accurateSearchs = accurateSearchs;
	}
	
	@Override
	public Predicate toPredicate(Root<T> r, CriteriaQuery<?> q, CriteriaBuilder b) {

		for(int i=0,len=keywords.length; i<len; i++) {
			for(int j=0,len2=searchFields.length; j<len2; j++) {
				Predicate predicates = b.like(r.get(searchFields[j]).as(String.class), "%"+keywords[i]+"%");
				q.where(b.or(predicates));
			}
		}
		
		for(int i=0,len=accurateSearchs.length; i<len; i++) {
			AccurateSearch accurateSearch = accurateSearchs[i];
			Predicate predicates = null;
			if(accurateSearch.getBind().equals("equal")) {
				predicates = b.equal(r.get(accurateSearch.getField()).as(Integer.class), accurateSearch.getValue());
			}
			q.where(b.and(predicates));
		}
		
		Predicate customPredicate = this.customPredicate(r, q, b, this.getArgs());
		if(customPredicate != null) {
			q.where(b.and(customPredicate));
		}
		
		return q.getRestriction();
	}
	
	public Predicate customPredicate(Root<T> r, CriteriaQuery<?> q, CriteriaBuilder b, Object[] args) {
		return null;
	}

}
