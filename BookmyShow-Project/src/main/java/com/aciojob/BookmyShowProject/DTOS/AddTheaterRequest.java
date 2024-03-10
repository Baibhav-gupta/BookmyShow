package com.aciojob.BookmyShowProject.DTOS;

import com.aciojob.BookmyShowProject.ENUMS.City;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTheaterRequest {
    private String name;
    private String address;
    //To keep Enumerated in String format
    @Enumerated(value = EnumType.STRING)
    private City city;
    private Integer noOfClassicSeat;
    private Integer noOfPremiumSeat;
    private Integer seatPerRow;

}
