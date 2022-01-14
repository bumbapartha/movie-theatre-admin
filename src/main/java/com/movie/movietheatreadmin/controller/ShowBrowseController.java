package com.movie.movietheatreadmin.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.service.ShowBrowseService;

@RestController
public class ShowBrowseController {
	
	private ShowBrowseService showBrowseService;
	
	@Autowired
	ShowBrowseController(ShowBrowseService showBrowseService){
		this.showBrowseService = showBrowseService;
	}
	
	@GetMapping("/show/browse")
	public List<Show> browseShow(@QueryParam(value = "city") String city,
			@QueryParam(value = "date") String date){
		return showBrowseService.browseShow(city, date);
	}

}
