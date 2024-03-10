package com.aciojob.BookmyShowProject.DTOS;

import com.aciojob.BookmyShowProject.ENUMS.Genre;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {
   // @Column(unique = true)
    private String movieName;
    // Genre genre;
    private Double rating;
    private Genre genre;
    private LocalDate releaseDate;
}
