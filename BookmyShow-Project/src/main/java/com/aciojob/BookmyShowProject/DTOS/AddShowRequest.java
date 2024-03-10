package com.aciojob.BookmyShowProject.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddShowRequest {
    private LocalDate showDate;
    private LocalTime relaeseTime;
    //To add any show we need
    //1.Movie Entity-movie name
    //2.Theater Entity-theaterId
    private String movieName;// unique so u can get Movie entity fom it
    private Integer theaterId;

}
