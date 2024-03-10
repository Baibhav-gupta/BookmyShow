package com.aciojob.BookmyShowProject.Services;

import com.aciojob.BookmyShowProject.DTOS.AddMovieRequest;
import com.aciojob.BookmyShowProject.Models.Movie;
import com.aciojob.BookmyShowProject.Repository.MovieRepository;
import com.aciojob.BookmyShowProject.Transformer.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest)throws Exception
    {
        Movie movie= MovieTransformer.convertAddMovieRequestToMovieEntity(addMovieRequest);
        movieRepository.save(movie);
        return "Movie added Successfully";
    }
}
