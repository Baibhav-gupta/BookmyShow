package com.aciojob.BookmyShowProject.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String mobNo;
    private Integer age;
    @Column(unique = true)
    private String emailId;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> ticketList=new ArrayList<>();

    //@GeneratedValue(strategy = GenerationType.IDENTITY)

}
