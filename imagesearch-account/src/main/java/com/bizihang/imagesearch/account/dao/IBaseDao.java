package com.bizihang.imagesearch.account.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface IBaseDao<T, ID extends Serializable> {
	void save(T entity);

	void update(T entity);

	void delete(T entity);

	void deleteById(ID id);

	void deleteAll(Collection<T> entities);

	T findById(ID id);

	boolean contains(T entity);

	T findByHQL(String hqlString, Object... values);

	List<T> findListByHQL(String hqlString, Object... values);
}
