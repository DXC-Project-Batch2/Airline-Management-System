package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface AdminSecurityService<E>{
	E save(E e);
	List<E> findByUsername(String username);
	List<E> findAll();
	boolean update(E e);
	public void delete(String username);
}