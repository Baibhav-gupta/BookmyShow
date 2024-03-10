package com.aciojob.BookmyShowProject.Services;

import com.aciojob.BookmyShowProject.DTOS.AddTheaterRequest;
import com.aciojob.BookmyShowProject.ENUMS.SeatType;
import com.aciojob.BookmyShowProject.Models.Theater;
import com.aciojob.BookmyShowProject.Models.TheaterSeat;
import com.aciojob.BookmyShowProject.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest)
    {
        Theater theater=Theater.builder()
                .name(addTheaterRequest.getName())
                .city(addTheaterRequest.getCity())
                .address(addTheaterRequest.getAddress())
                .build();
        createTheaterSeat(theater,addTheaterRequest);
        return"Theater and its seats have been saved to DB";
    }
    public void createTheaterSeat(Theater theater,AddTheaterRequest addTheaterRequest)
    {
        int noOfClassicSeat=addTheaterRequest.getNoOfClassicSeat();
        int noOfPremiumSeat=addTheaterRequest.getNoOfPremiumSeat();
        int seatPerRow=addTheaterRequest.getSeatPerRow();
        List<TheaterSeat> theaterSeatList=new ArrayList<>();
        int row=0;
        char ch='A';
        for(int k=1;k<=noOfClassicSeat;k++)
        {
            if(k%seatPerRow==1)
            {
                row++;
                ch='A';
            }
            String seatno=row+" "+ch;
            ch=(char)(ch+1);
            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .seatNo(seatno)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);

        }
        for(int k=1;k<=noOfPremiumSeat;k++)
        {
            if(k%seatPerRow==1)
            {
                row++;
                ch='A';
            }
            String seatno=row+" "+ch;
            ch=(char)(ch+1);
            TheaterSeat theaterSeat=TheaterSeat.builder()
                    .seatNo(seatno)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);

        }
        //for bi directional mapping
        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);
    }
}
