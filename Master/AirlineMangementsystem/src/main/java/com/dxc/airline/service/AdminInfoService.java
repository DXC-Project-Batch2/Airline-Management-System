package com.dxc.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.airline.model.AdminInfo;
@Service
public interface AdminInfoService<E>{
	E save(E e);
	AdminInfo findByUsername(String username);
	List<E> findAll();
	boolean update(E e);
	boolean delete(String username);
}