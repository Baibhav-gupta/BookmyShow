package com.aciojob.BookmyShowProject.Controllers;

import com.aciojob.BookmyShowProject.DTOS.BookTicketRequest;
import com.aciojob.BookmyShowProject.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @PostMapping("/bookticket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest)
    {
        return ticketService.bookTicket(bookTicketRequest);
    }
}
