package com.aciojob.BookmyShowProject.Services;

import com.aciojob.BookmyShowProject.DTOS.AddShowRequest;
import com.aciojob.BookmyShowProject.DTOS.AddShowSeatRequest;
import com.aciojob.BookmyShowProject.ENUMS.SeatType;
import com.aciojob.BookmyShowProject.Models.*;
import com.aciojob.BookmyShowProject.Repository.MovieRepository;
import com.aciojob.BookmyShowProject.Repository.ShowRepository;
import com.aciojob.BookmyShowProject.Repository.ShowSeatRepository;
import com.aciojob.BookmyShowProject.Repository.TheaterRepository;
import com.aciojob.BookmyShowProject.Transformer.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    public String addShow(AddShowRequest addShowRequest)
    {
        Show show= ShowTransformer.convertAddShowRequestToShowEntity(addShowRequest);

        //Set the foreign key connections now
        Movie movie=movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        Optional<Theater> optionalTheater=theaterRepository.findById(addShowRequest.getTheaterId());

       // Optional<Theater> optionalTheater=theaterRepository.findTheaterByTheaterId(addShowRequest.getTheaterId());
       Theater theater=optionalTheater.get();

//        if(optionalTheater.isPresent())
//        {
//            theater=optionalTheater.get();
//        }

        //setting fk (saving 1 side)
        show.setMovie(movie);
        show.setTheater(theater);

        //Bidirectional mapping or (Saving another side)
        movie.getShowList().add(show);
        theater.getShowList().add(show);

        //now save either child or both parent to db , So here we will save Jst child(because its jst one)
        // and is easy to save jst one insted of saving 2
        show=showRepository.save(show);
        return "Show added Successfully with showId"+show.getShowId();
    }
    public String createShowSeat(AddShowSeatRequest addShowSeatRequest)
    {
        Show show=showRepository.findById(addShowSeatRequest.getShowId()).get();
        Theater theater=show.getTheater();
        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();

        List<ShowSeat> showSeatList=new ArrayList<>();
        for(TheaterSeat theaterSeat:theaterSeatList)
        {
             ShowSeat showSeat=ShowSeat.builder()
                     .seatNo(theaterSeat.getSeatNo())
                     .seatType(theaterSeat.getSeatType())
                     .isAvailable(true)
                     .isFoodAttached(false)
                     .show(show)
                     .build();
             if(theaterSeat.getSeatType().equals(SeatType.CLASSIC))
             {
                 showSeat.setCost(addShowSeatRequest.getPriceOfClassicSeat());
             }
             else
             {
                 showSeat.setCost(addShowSeatRequest.getPricaOfPremmiumSeat());
             }
             showSeatList.add(showSeat);
        }
    show.setShowSeatList(showSeatList);
        showSeatRepository.saveAll(showSeatList);
        // either save paren

        return"showseat is enabled successfully";
    }

}
