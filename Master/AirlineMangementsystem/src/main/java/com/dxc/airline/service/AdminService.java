package com.dxc.airline.service;

import java.util.List;

import com.dxc.airline.model.Admin;


public interface AdminService<E> {
	
	public List<E> findAll();

	public boolean save(E e);
	
	public boolean update(E e);

	public E findById(String username);

	public void deleteById(String username);

}
