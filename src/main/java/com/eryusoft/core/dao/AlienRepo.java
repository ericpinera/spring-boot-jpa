package com.eryusoft.core.dao;

import org.springframework.data.repository.CrudRepository;

import com.eryusoft.core.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>
{
	
}
