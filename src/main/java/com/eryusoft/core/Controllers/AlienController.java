package com.eryusoft.core.Controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eryusoft.core.dao.AlienRepo;
import com.eryusoft.core.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "Home.html";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "Home.html";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.html");
		
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByAtech("Java"));
		
		System.out.println(repo.findByAidGreaterThan(101));
		
		mv.addObject("alien", alien);		
		
		return mv;
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens()
	{
		return repo.findAll().toString();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getAliens(@PathVariable("aid") int aid)
	{
		return repo.findById(aid).toString();
	}

}
