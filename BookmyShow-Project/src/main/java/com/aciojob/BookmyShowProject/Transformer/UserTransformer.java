package com.aciojob.BookmyShowProject.Transformer;

import com.aciojob.BookmyShowProject.DTOS.AddUserRequest;
import com.aciojob.BookmyShowProject.Models.User;

public class UserTransformer {
    public static User convertUserDTOtoUserEntity(AddUserRequest addUserRequest){
        User obj=User.builder()
                .age(addUserRequest.getAge())
                .name(addUserRequest.getName())
                .emailId(addUserRequest.getEmailId())
                .mobNo(addUserRequest.getMobNo())
                .build();
        return obj;
    }
}
