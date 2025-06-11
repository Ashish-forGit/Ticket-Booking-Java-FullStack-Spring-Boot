package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;

import java.io.File;
import java.util.List;

public class UserBookingService {
    private User user;

    private ObjectMapper  objectMapper = new ObjectMapper();

    private List<User> userList;

    private static final String USERS_PATH = "../localDb/users.jason";

     public UserBookingService(User user1) {

         this.user = user1;
         File users = new File(USERS_PATH);
         userList = objectMapper.readValue(users, TypeReference< List<User>>() {});

     }

}
