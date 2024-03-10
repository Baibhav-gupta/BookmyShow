package com.aciojob.BookmyShowProject.Models;

import com.aciojob.BookmyShowProject.ENUMS.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="showseat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;
    private String seatNo;
    //private SeatType seatType;
    private Integer cost;//keeps on every show
    private boolean isAvailable;
    private boolean isFoodAttached;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
// join with theater
    // join with show
    @ManyToOne
    @JoinColumn
    private Show show;
}
