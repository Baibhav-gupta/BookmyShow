package com.aciojob.BookmyShowProject.Models;

import com.aciojob.BookmyShowProject.ENUMS.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theaterSeat")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
//One theater can have many theater seat
    @ManyToOne
    @JoinColumn
    private Theater theater;
}
