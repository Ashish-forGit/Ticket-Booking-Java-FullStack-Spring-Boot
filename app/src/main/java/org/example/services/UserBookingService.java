package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;

import java.io.File;

public class UserBookingService {
    private User user;

//    private ObjectMapper  objectMapper = new ObjectMapper();

    private static final String USERS_PATH = "../localDb/users.jason";

     public UserBookingService(User user1) {

         this.user = user1;
         File user = new File(USERS_PATH);

     }

}
