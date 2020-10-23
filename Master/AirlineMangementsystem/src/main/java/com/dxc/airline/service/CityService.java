package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CityService<E>{
	E save(E e);
	E findBycity(String city);
	List<E> findAll();
	E update(E e);
	boolean delete(String city);
}