package com.webproject.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webproject.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{
	
	List<Alien> findBytech(String tech);
	
	List<Alien> findByaidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);
}
