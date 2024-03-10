package com.aciojob.BookmyShowProject.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name ="ticket")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String movieName;
    private String theaterAddress;
    private Integer totalPrice;
    private LocalDate showDate;
    private LocalTime showTime;
    private String bookedSeat;
@ManyToOne
    @JoinColumn
    private Show show;
@ManyToOne
    @JoinColumn
    private User user;


}
