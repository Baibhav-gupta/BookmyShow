package com.aciojob.BookmyShowProject.Repository;

import com.aciojob.BookmyShowProject.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
