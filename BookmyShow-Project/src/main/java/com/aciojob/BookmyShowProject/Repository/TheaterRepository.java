package com.aciojob.BookmyShowProject.Repository;

import com.aciojob.BookmyShowProject.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {

   // Theater findTheaterByTheaterId(Integer theaterId);

}
