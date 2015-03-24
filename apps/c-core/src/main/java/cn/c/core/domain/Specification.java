package cn.c.core.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public final class Specification<T extends IdEntity> implements org.springframework.data.jpa.domain.Specification<T> {
	private String[] searchFields;
	private String[] keywords;
	
	public Specification(String[] searchFields, String[] keywords) {
		this.searchFields = searchFields;
		this.keywords = keywords;
	}
	
	@Override
	public Predicate toPredicate(Root<T> r, CriteriaQuery<?> q, CriteriaBuilder b) {
		Predicate[] predicates = new Predicate[keywords.length * searchFields.length];

		int index = 0;
		for(int i=0,len=keywords.length; i<len; i++) {
			for(int j=0,len2=searchFields.length; j<len2; j++) {
				predicates[index++] = b.like(r.get(searchFields[j]).as(String.class), "%"+keywords[i]+"%");
				q.where(b.or(predicates[i]));
			}
		}
		
		//Predicate p1 = b.equal(r.get("version").as(Integer.class), 0);
		
		return q.getRestriction();
	}

}
