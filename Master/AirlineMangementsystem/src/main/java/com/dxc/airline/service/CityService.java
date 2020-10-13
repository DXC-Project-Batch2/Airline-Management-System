package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CityService<E>{
	boolean save(E e);
	E find(String city);
	List<E> findAll();
	boolean update(E e);
	boolean delete(String city);
}