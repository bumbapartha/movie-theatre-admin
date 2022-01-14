package com.movie.movietheatreadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movietheatreadmin.model.Movie;
import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.model.Theatre;
import com.movie.movietheatreadmin.repository.MovieRepository;
import com.movie.movietheatreadmin.repository.ShowRepository;
import com.movie.movietheatreadmin.repository.TheatreRepository;

@Service
public class ShowService {
	
	private ShowRepository repository;
	private MovieRepository movieRepository;
	private TheatreRepository theatreRepository;
	
	@Autowired
	ShowService(ShowRepository repository, 
			MovieRepository movieRepository, 
			TheatreRepository theatreRepository){
		this.repository = repository;
		this.movieRepository = movieRepository;
		this.theatreRepository = theatreRepository;
	}
	
	public List<Show> getListOfShows() {
		return repository.findAll();
	}

	public Show createShow(Show show) {
		if(show == null) {
			throw  new RuntimeException("Show should not be empty");
		}
		if(show.getMovie() == null) {
			throw  new RuntimeException("Show should have a attached movie");
		}
		
		Optional<Movie> movie = movieRepository.findById(show.getMovie().getId());
		if(movie.isPresent()) {
			show.setMovie(movie.get());
			
		}
		else {
			throw  new RuntimeException("Movie not found "+show.getMovie().getId());
		}
		
		Optional<Theatre> theatre = theatreRepository.findById(show.getTheatre().getId());
		if(theatre.isPresent()) {
			show.setTheatre(theatre.get());
			
		}
		else {
			throw  new RuntimeException("Theratre not found "+show.getTheatre().getId());
		}
			
		return repository.save(show);
	}

}
