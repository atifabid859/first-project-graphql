package com.code.graphql.controller;

import com.code.graphql.entity.User;
import com.code.graphql.serive.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument String name,@Argument String phone,@Argument String email,@Argument String password){
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }
    @QueryMapping(name = "getUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getSingleUser(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
}
