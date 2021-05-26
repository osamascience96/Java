package com.webproject.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.webproject.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{
	
}
