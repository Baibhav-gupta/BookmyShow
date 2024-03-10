package com.aciojob.BookmyShowProject.Controllers;

import com.aciojob.BookmyShowProject.DTOS.AddShowRequest;
import com.aciojob.BookmyShowProject.DTOS.AddShowSeatRequest;
import com.aciojob.BookmyShowProject.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("/addshow")
    public String addShow(@RequestBody AddShowRequest addShowRequest)
    {
        return showService.addShow(addShowRequest);
    }
    @PostMapping("/createshowseat")
    public String enableShowSeat(@RequestBody AddShowSeatRequest addShowSeatRequest)
    {
       return showService.createShowSeat(addShowSeatRequest);
    }
}
