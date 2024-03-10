package com.aciojob.BookmyShowProject.Repository;

import com.aciojob.BookmyShowProject.Models.Movie;
import com.aciojob.BookmyShowProject.Models.Show;
import com.aciojob.BookmyShowProject.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {
    Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);

}
