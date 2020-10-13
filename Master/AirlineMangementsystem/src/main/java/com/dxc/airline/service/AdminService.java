package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.Admin;
@Service

public interface AdminService<E> {
	
	public List<E> findAll();

	public boolean save(E e);
	
	public boolean update(E e);

	public E findById(String username);

	public void deleteById(String username);

}
