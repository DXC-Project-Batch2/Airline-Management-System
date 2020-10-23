package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AdminInfoService<E>{
	E save(E e);
	E findByUsername(String username);
	List<E> findAll();
	E update(E e);
	void delete(String username);
}