package com.eryusoft.core.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eryusoft.core.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>
{

	List<Alien> findByAtech(String atech);
	
	List<Alien> findByAidGreaterThan(int aid);
	
	
}
