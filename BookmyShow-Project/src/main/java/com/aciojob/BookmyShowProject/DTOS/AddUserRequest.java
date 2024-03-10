package com.aciojob.BookmyShowProject.DTOS;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String name;
    private String mobNo;
    private Integer age;
    @Column(unique = true)
    private String emailId;
}
