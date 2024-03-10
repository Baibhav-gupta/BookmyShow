package com.aciojob.BookmyShowProject.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddShowSeatRequest {
private Integer showId;
private Integer priceOfClassicSeat;
private Integer pricaOfPremmiumSeat;
}
