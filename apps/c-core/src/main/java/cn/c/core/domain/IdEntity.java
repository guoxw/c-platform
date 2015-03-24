package cn.c.core.domain;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 
 * @author hz453@126.com
 */
@MappedSuperclass
public class IdEntity extends AbstractPersistable<Long>{

	private static final long serialVersionUID = -7443719330553954877L;

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	@Override
	public boolean isNew() {
		return null == getId() || 1 > getId();
	}
}
