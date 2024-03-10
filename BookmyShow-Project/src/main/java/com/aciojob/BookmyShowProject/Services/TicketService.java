package com.aciojob.BookmyShowProject.Services;

import com.aciojob.BookmyShowProject.DTOS.BookTicketRequest;
import com.aciojob.BookmyShowProject.Models.*;
import com.aciojob.BookmyShowProject.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private MovieRepository movieRepository;
    public String bookTicket(BookTicketRequest bookTicketRequest)
    {
        Show show=findRightShow(bookTicketRequest);

        List<ShowSeat> showSeatList=show.getShowSeatList();
        int totalPrice=0;
        for(ShowSeat showSeat:showSeatList)
        {
            if(bookTicketRequest.getRequestedSeatNo().contains(showSeat.getSeatNo()))
            {
                showSeat.setAvailable(false);
                totalPrice=totalPrice+showSeat.getCost();
            }

        }
        User user=userRepository.findById(bookTicketRequest.getUserId()).get();

        Ticket ticket=Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .theaterAddress(show.getTheater().getAddress())
                .showDate(show.getShowDate())
                .showTime(show.getReleaseTime())
                .bookedSeat(bookTicketRequest.getRequestedSeatNo().toString())
                .user(user)
                .show(show)
                .build();
        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);
         ticketRepository.save(ticket);
         return "ticket has been booked";
    }
    private Show findRightShow(BookTicketRequest bookTicketRequest)
    {
        Optional<Theater> theater=theaterRepository.findById(bookTicketRequest.getTheaterId());
        Theater theater1=theater.get();
        Movie movie=movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Show show=showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate()
        ,bookTicketRequest.getShowTime(),movie,theater1);
        return show;
    }

}
