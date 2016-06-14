package com.bizihang.imagesearch.account.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bizihang.imagesearch.account.dao.IBaseDao;

public class BaseDao<T, ID extends Serializable> implements IBaseDao<T, ID> {

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type genericType = this.getClass().getGenericSuperclass();
		this.entityType = (Class<T>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
	}

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Class<T> entityType;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		System.out.println("------------->" + entityType);
		this.getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void deleteById(ID id) {
		this.getSession().delete(this.findById(id));
	}

	@Override
	public void deleteAll(Collection<T> entities) {

	}

	@Override
	public T findById(ID id) {
		return this.getSession().get(entityType, id);
	}

	@Override
	public boolean contains(T entity) {
		return this.getSession().contains(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByHQL(String hqlString, Object... values) {
		Query query = this.getSession().createQuery(hqlString);

		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}

		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByHQL(String hqlString, Object... values) {
		Query query = this.getSession().createQuery(hqlString);

		if (null != values) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}

		return (List<T>) query.list();
	}
}
