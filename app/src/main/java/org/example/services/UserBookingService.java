package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;

    private ObjectMapper  objectMapper = new ObjectMapper();

    private List<User> userList;

    private static final String USERS_PATH = "app/src/main/java/org/example/localDb/users.jason";

     public UserBookingService(User user1) throws IOException
     {

         this.user = user1;
         File users = new File(USERS_PATH);
         userList = objectMapper.readValue(users, new TypeReference<List<User>>() {
         });

     }
    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }

}
