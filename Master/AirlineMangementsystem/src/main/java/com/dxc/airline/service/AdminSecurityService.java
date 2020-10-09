package com.dxc.airline.service;

import java.util.List;

public interface AdminSecurityService<E>{
	boolean save(E e);
	E find(String username);
	List<E> findAll();
	boolean update(E e);
	boolean delete(String username);
}