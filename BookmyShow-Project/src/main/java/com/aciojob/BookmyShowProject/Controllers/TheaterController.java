package com.aciojob.BookmyShowProject.Controllers;

import com.aciojob.BookmyShowProject.DTOS.AddTheaterRequest;
import com.aciojob.BookmyShowProject.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;
    @PostMapping("/add")
    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest)
    {
        return theaterService.addTheater(addTheaterRequest);
    }
}
