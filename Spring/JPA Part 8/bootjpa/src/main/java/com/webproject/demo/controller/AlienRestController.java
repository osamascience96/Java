package com.webproject.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webproject.demo.dao.AlienRepo;
import com.webproject.demo.model.Alien;

@RestController
public class AlienRestController {
	
	@Autowired
	AlienRepo alienRepo;
	
	// create the delete controller method
	@DeleteMapping("alien/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid) {
		alienRepo.deleteById(aid);
		return "deleted";
	}
	
	// create the put(update) controller method
	@PutMapping(path="alien", consumes = {"application/json"})
	public Alien saveOrAddAlien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}
	
	@PostMapping(path="alien", consumes = {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}
	
	@GetMapping("aliens")
	public List<Alien> getallaliens() {
		return alienRepo.findAll();
	}
	
	@GetMapping(path="alien/{aid}", produces = {"application/json"})
	public Optional<Alien> getOneAlien(@PathVariable("aid") int aid) {
		return alienRepo.findById(aid);
	}
}
