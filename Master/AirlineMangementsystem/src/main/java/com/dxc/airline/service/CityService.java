package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CityService<E>{
	E save(E e);
	List<E> findByCityname(String city);
	List<E> findAll();
	boolean update(E e);
	boolean delete(String city);
}