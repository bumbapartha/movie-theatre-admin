package com.movie.movietheatreadmin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.movie.movietheatreadmin.model.Movie;
import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.model.Theatre;
import com.movie.movietheatreadmin.repository.MovieRepository;
import com.movie.movietheatreadmin.repository.ShowRepository;
import com.movie.movietheatreadmin.repository.TheatreRepository;


@Component
public class InitData implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private ShowRepository  showRepository;
    
    @Autowired
    private TheatreRepository  theatreRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
			seedData();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    private void seedData() throws ParseException {
    	Theatre inox = Theatre.builder().name("Inox").city("Kolkata").build();
    	Theatre pvr = Theatre.builder().name("PVR").city("Kolkata").build();
    	Theatre bioscope = Theatre.builder().name("Bioscope").city("Kolkata").build();
    	Theatre inoxM = Theatre.builder().name("Inox(M)").city("Mumbai").build();
    	Theatre pvrM = Theatre.builder().name("PVR").city("Mumbai").build();
    	theatreRepository.saveAll(Arrays.asList(inox, pvr, bioscope, inoxM, pvrM));
    	
    	Movie movie1 = Movie.builder().name("Matrix").build();
    	Movie movie2 = Movie.builder().name("Avatar").build();
    	Movie movie3 = Movie.builder().name("Saving Private Ryan").build();
    	Movie movie4 = Movie.builder().name("Titanic").build();
    	Movie movie5 = Movie.builder().name("Gravity").build();
    	movieRepository.saveAll(Arrays.asList(movie1,movie2,movie3,movie4,movie5));
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Show show1Movie1Theatre1 =  Show.builder()
    				.startDate(sdf.parse("2022-01-10"))
    				.endDate(sdf.parse("2022-02-10"))
    				.startHour(16).startMin(30)
    				.theatre(inox).movie(movie1)
    				.price(200.0)
    				.build();
    	Show show2Movie1Theatre2 =  Show.builder()
				.startDate(sdf.parse("2022-01-10"))
				.endDate(sdf.parse("2022-02-10"))
				.startHour(19).startMin(0)
				.theatre(pvr).movie(movie1)
				.price(250.0)
				.build();
	    Show show3Movie1Theatre1 =  Show.builder()
					.startDate(sdf.parse("2022-01-11"))
					.endDate(sdf.parse("2022-02-01"))
					.startHour(17).startMin(30)
					.theatre(pvrM).movie(movie1)
    				.price(200.0)
					.build();
	    
		Show show1Movie2Theatre1 =  Show.builder()
					.startDate(sdf.parse("2022-01-10"))
					.endDate(sdf.parse("2022-02-10"))
					.startHour(16).startMin(30)
					.theatre(bioscope).movie(movie2)
    				.price(100.0)
					.build();
		
		Show show2Movie2Theatre2 =  Show.builder()
				.startDate(sdf.parse("2022-02-01"))
				.endDate(sdf.parse("2022-02-10"))
				.startHour(19).startMin(0)
				.theatre(pvr).movie(movie2)
				.price(250.0)
				.build();
		
		Show show1Movie3Theatre1 =  Show.builder()
				.startDate(sdf.parse("2022-01-10"))
				.endDate(sdf.parse("2022-02-10"))
				.startHour(16).startMin(30)
				.theatre(inox).movie(movie3)
				.price(150.0)
				.build();
		
		Show show2Movie3Theatre2 =  Show.builder()
				.startDate(sdf.parse("2022-01-01"))
				.endDate(sdf.parse("2022-01-31"))
				.startHour(19).startMin(0)
				.theatre(pvr).movie(movie3)
				.price(300.0)
				.build();
	
    	showRepository.saveAll(Arrays.asList(
    			show1Movie1Theatre1, show2Movie1Theatre2, show3Movie1Theatre1,  //First Movie 3 shows
    			show1Movie2Theatre1, show2Movie2Theatre2,						//Movie 2
    			show1Movie3Theatre1, show2Movie3Theatre2						//Movie 3
    			
    	));
	
    }

}