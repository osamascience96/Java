package com.webproject.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webproject.demo.dao.AlienRepo;
import com.webproject.demo.model.Alien;

@RestController
public class AlienRestController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@PostMapping(path="alien", consumes = {"application/json"})
	public Alien addalien(@RequestBody Alien alien) {
		alienRepo.save(alien);
		return alien;
	}
	
	@GetMapping("aliens")
	public List<Alien> getallaliens() {
		return alienRepo.findAll();
	}
	
	@GetMapping("alien/{aid}")
	public Optional<Alien> getOneAlien(@PathVariable("aid") int aid) {
		return alienRepo.findById(aid);
	}
}
