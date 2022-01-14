package com.movie.movietheatreadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.service.ShowService;

@RestController
public class ShowController {
	
	private ShowService service;
	
	@Autowired
	ShowController(ShowService service){
		this.service = service; 
	}
	
	@GetMapping("/show")
	public List<Show> getListOfShows() {
		return service.getListOfShows();
	}
	
	@PostMapping("/show")
	public Show createShow(@RequestBody Show show) {
		return service.createShow(show);
	}
	
	
	
	
	

}
