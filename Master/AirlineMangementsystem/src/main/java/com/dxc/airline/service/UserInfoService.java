package com.dxc.airline.service;

import java.util.List;

public interface UserInfoService<E> {
	
	public List<E> findAll();

	public boolean save(E e);
	
	public boolean update(E e);

	public E findById(long id);

	public void deleteById(long id);

}
