package com.movie.movietheatreadmin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.model.Theatre;
import com.movie.movietheatreadmin.repository.ShowRepository;
import com.movie.movietheatreadmin.repository.TheatreRepository;

@Service
public class ShowBrowseService {
	
	private ShowRepository showRepository;
	private TheatreRepository theatreRepository;
	
	@Autowired
	ShowBrowseService(ShowRepository repository, 
			TheatreRepository theatreRepository){
		this.showRepository = repository;
		this.theatreRepository = theatreRepository;
	}
	
	public List<Show> browseShow(String city, String strDate) {
		Date bookingDate;
		try {
			bookingDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			bookingDate = new Date();
			e.printStackTrace();
		}
		List<Theatre> theatreList = this.theatreRepository.findAllByCity(city);
		List<Show> showList = new ArrayList<>();
		for (Iterator<Theatre> iterator = theatreList.iterator(); iterator.hasNext();) {
			Theatre theatre = (Theatre) iterator.next();
			List<Show> thisTheatreShow = showRepository.findAllByTheatre(theatre);
			for (Iterator<Show> iterator2 = thisTheatreShow.iterator(); iterator2.hasNext();) {
				Show show = iterator2.next();
				
				if((bookingDate.getTime() >= show.getStartDate().getTime() &&
						bookingDate.getTime() <= show.getEndDate().getTime())) {
					showList.add(show);
				}
				
			}
		}
		return showList;
	}
}
