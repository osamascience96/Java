package com.webproject.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webproject.demo.dao.AlienRepo;
import com.webproject.demo.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		  repo.save(alien);
		  return "home.jsp";
	}
	
	@RequestMapping("getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showalien.jsp");
		Alien alien = repo.findById(aid).orElse(null);
		mv.addObject("alien", alien);
		return mv;
	}
	
	@RequestMapping("deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		// delete using id
		repo.deleteById(aid);
		return "home.jsp?response=deletesuccess";
	}
	
	@RequestMapping("showallaliens")
	public ModelAndView showAllAliens() {
		// init the modelandview object 
		ModelAndView mv = new ModelAndView("showallaliens.jsp");
		ArrayList<Alien> alienLists = (ArrayList<Alien>) repo.findAll();
		mv.addObject("alienList", alienLists);
		
		// did some experiment to other type of queries rather than simpler ones.
		System.out.println(repo.findBytech("java"));
		System.out.println(repo.findByaidGreaterThan(101));
		System.out.println(repo.findByTechSorted("java"));
		
		return mv;
	}
	
	@RequestMapping("aliens")
	@ResponseBody
	public List<Alien> getallaliens() {
		return repo.findAll();
	}
	
	@RequestMapping("alien/{aid}")
	@ResponseBody
	public Optional<Alien> getOneAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
}
