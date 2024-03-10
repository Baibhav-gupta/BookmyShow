package com.aciojob.BookmyShowProject.Transformer;

import com.aciojob.BookmyShowProject.DTOS.AddMovieRequest;
import com.aciojob.BookmyShowProject.Models.Movie;

public class MovieTransformer {
    public static Movie convertAddMovieRequestToMovieEntity(AddMovieRequest addMovieRequest)
    {
        Movie obj=Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .releaseDate(addMovieRequest.getReleaseDate())
                .genre(addMovieRequest.getGenre())
                .rating(addMovieRequest.getRating())
                .build();
        return obj;
    }
}
