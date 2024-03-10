package com.aciojob.BookmyShowProject.Controllers;

import com.aciojob.BookmyShowProject.DTOS.AddMovieRequest;
import com.aciojob.BookmyShowProject.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/addMovie")
    public String addMovie(@RequestBody AddMovieRequest addMovieRequest)
    {
        try {
            String result= movieService.addMovie(addMovieRequest);
            return result;
        }
       catch (Exception e)
       {
          // throw new Exception()
           return e.getMessage();
       }
    }
}
