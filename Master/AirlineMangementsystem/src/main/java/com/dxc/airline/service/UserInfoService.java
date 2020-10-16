package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface UserInfoService<E> {
	
	public List<E> findAll();

	public E save(E e);
	
	public E update(E e);

	public E findByUsername(String username);

	public void deleteById(String username);

}
