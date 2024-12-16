package com.code.graphql.serive.impl;

import com.code.graphql.entity.User;
import com.code.graphql.exception.ExceptionHelper;
import com.code.graphql.repository.UserRepository;
import com.code.graphql.serive.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
     UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(int userId) {
         User user = userRepository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFountException);
         return user;
    }

    @Override
    public User updateUser(User user, int userId) {
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFountException);
        userRepository.delete(user);
        return true;
    }
}
