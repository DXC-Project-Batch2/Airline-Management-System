package com.dxc.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.airline.model.City;

public class CityServiceImplementation implements CityService<City>{

	@Autowired
	@Override
	public boolean save(City e) {
		boolean res=false;
		if(adminInfoRepository.save(e) != null)
		{
			res=true;
		}
		return res;
	}

	@Override
	public City find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(City e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
