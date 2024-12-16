package com.code.graphql.serive;

import com.code.graphql.entity.User;

import java.util.List;

public interface UserService {
    //creating user
    User createUser(User user);
    //getting All Users
    List<User> getAllUsers();
    //getting single user
    User getSingleUser(int userId);
    //update by user
    User updateUser(User user,int userId);
    //delete by userId
    boolean deleteUser(int userId);
}
