package com.ibm.train.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.train.web.action.PageContext;
import com.ibm.train.web.action.PageJsonData;

/**
 * @author HuZhonghua
 * 
 */
public abstract class AbstractService<T> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@PersistenceContext(unitName = "clinic")
	protected EntityManager em;

	protected Class<T> entity;

	public AbstractService(Class<T> entity) {
		this.entity = entity;
	}

	public T create(T entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	public T update(T entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	public void delete(T entity) throws Exception {
		em.remove(em.merge(entity));
	}

	public void deleteByIds(String ids) throws Exception {
		for (String id : ids.split(",")) {
			em.remove(em.getReference(entity.getClass(), id));
		}
	}

	public T findById(String id) {
		return em.find(entity, id);
	}

	public PageJsonData getPageData(String sql) {
		return getPageData(sql, null, PageContext.getOffset(),
				PageContext.getPageSize());
	}

	public PageJsonData getPageData(String sql, Object[] params, int offset,
			int pageSize) {
		Query query = em.createQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i - 1]);
			}
		}
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		return new PageJsonData(offset / pageSize + 1, query.getResultList(),
				getCount(sql, params), pageSize);
	}

	private Integer getCount(String sql, Object[] params)
			throws StringIndexOutOfBoundsException {
		StringBuffer sb = new StringBuffer(sql);
		sb.delete(0, sb.indexOf("from"));
		sb.insert(0, "select count(*)  ");
		Query query = em.createQuery(sb.toString());
		if (params != null && params.length > 0) {
			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i - 1]);
			}
		}
		return ((Long) query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public T querySingle(String sql) {
		return (T) em.createQuery(sql).setMaxResults(1).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> query(String sql) {
		return em.createQuery(sql).getResultList();
	}

}
