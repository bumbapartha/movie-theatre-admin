package com.movie.movietheatreadmin.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movietheatreadmin.model.BookingRequest;
import com.movie.movietheatreadmin.model.BookingResponse;
import com.movie.movietheatreadmin.model.Show;
import com.movie.movietheatreadmin.model.TicketBooked;
import com.movie.movietheatreadmin.repository.ShowRepository;
import com.movie.movietheatreadmin.repository.TicketBookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	

	public BookingResponse reserveSeat(BookingRequest request) {
		
		Optional<Show> optShow = showRepository.findById(request.getShowId());
		if(optShow.isPresent()) {
			Show show = optShow.get();
			
			List<TicketBooked> alreadyBookedTicket =  
					ticketBookingRepository.findByShowAndSeatAndShowdate(show, request.getSeatChoice(), 
							request.getDate());
			
			for (Iterator<TicketBooked> iterator = alreadyBookedTicket.iterator(); iterator.hasNext();) {
				TicketBooked ticketBooked = (TicketBooked) iterator.next();
				if("CONFIRMED".equals(ticketBooked.getStatus())) {
					throw new RuntimeException("Selected Seat is not avaliable : "+request.getSeatChoice());
				}
				else if("RESERVED".equals(ticketBooked.getStatus()) 
						&& ticketBooked.getBookingTime().getTime()+(5*60*1000) > new Date().getTime()) {
					throw new RuntimeException("Selected Seat is reserved, try after some time : "+request.getSeatChoice());
				}
			}
			
			//Success case, Reserve SEAT
			ticketBookingRepository.save(
				TicketBooked.builder().bookingTime(new Date())
					.seat(request.getSeatChoice())
					.show(show)
					.showdate(request.getDate())
					.status("RESERVED")
					.build()
			);
			
			
			BookingResponse bookingResponse = new BookingResponse();
			bookingResponse.setRequest(request);
			bookingResponse.setActualPrice(show.getPrice());
			//Apply Discount if any
			int bookingCount = (int) ticketBookingRepository.count(); //Assuming all booking has been done by same user, as user is not implemented yet
			if(bookingCount>3) {
				//50% discount on this ticket
				bookingResponse.setDiscountPercentage(50);
				bookingResponse.setFinalPrice(bookingResponse.getActualPrice()/2);
			}
			else if(show.getStartHour()>14 && show.getStartHour()<18) {
				//20% discount on this ticket
				bookingResponse.setDiscountPercentage(20);
				bookingResponse.setFinalPrice((bookingResponse.getActualPrice() * 4) / 5);
			}
			else {
				//No discount
				bookingResponse.setDiscountPercentage(0);
				bookingResponse.setFinalPrice(bookingResponse.getActualPrice());
			}
			
			
			return bookingResponse;
		}
		else {
			throw new RuntimeException("Unknow Show : "+request.getShowId());
		}
		
	}
}
