package com.aciojob.BookmyShowProject.Models;

import com.aciojob.BookmyShowProject.ENUMS.City;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="theater")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theater {
    @Id
    private Integer theaterId;
    private String name;
    private String address;
    //To keep Enumerated in String format
    @Enumerated(value = EnumType.STRING)
    private City city;
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList=new ArrayList<>();
    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> showList=new ArrayList<>();
}
