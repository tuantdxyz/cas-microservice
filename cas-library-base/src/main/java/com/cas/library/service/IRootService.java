package com.cas.library.service;

import java.util.List;

public interface IRootService<T> {

	T create(T entity);

	T retrieve(T entity);

	void delete(T entity);

	void update(T entity);

	List<T> loadAll();

	T findById(int id);

}
