package com.aciojob.BookmyShowProject.Repository;

import com.aciojob.BookmyShowProject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
