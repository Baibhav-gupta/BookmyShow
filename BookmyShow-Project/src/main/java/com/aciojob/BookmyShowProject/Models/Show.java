package com.aciojob.BookmyShowProject.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="show")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;
    private LocalDate showDate;
    private LocalTime releaseTime;

    @ManyToOne
    @JoinColumn
    private Movie movie;
    //In its dto connect with movie repository and get Movie Entity with movie name or id which will be unique
    @ManyToOne
    @JoinColumn
    private Theater theater;
    //same for it to connect these foreign key attribute connect its dto(Show dto ) that you have made
    //and connect showService with their repository and by using findById or findByName get those Foreign key Entity
    //no its all wrong 27,31 & 32(corrected)
    // connect repository of movie and theater in show Service

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList=new ArrayList<>();
    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> ticketList=new ArrayList<>();
}
