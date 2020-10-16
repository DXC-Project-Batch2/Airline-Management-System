package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service

public interface AdminService<E> {
	
	public List<E> findAll();

	public E save(E e);
	
	public boolean update(E e);

	public E findById(String username);

	public void deleteById(String username);

}
