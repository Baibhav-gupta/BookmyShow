package com.aciojob.BookmyShowProject.Services;

import com.aciojob.BookmyShowProject.DTOS.AddUserRequest;
import com.aciojob.BookmyShowProject.Models.User;
import com.aciojob.BookmyShowProject.Repository.UserRepository;
import com.aciojob.BookmyShowProject.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest)
    {
        User user= UserTransformer.convertUserDTOtoUserEntity(addUserRequest);
        userRepository.save(user);
        return "user saved sucessfully";
    }
}
