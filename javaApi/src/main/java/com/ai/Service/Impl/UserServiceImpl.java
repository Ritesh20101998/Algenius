package com.ai.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.EntityClasses.User;
import com.ai.ExceptionClasses.UserNotFoundException;
import com.ai.Repositories.UserRepository;
import com.ai.Service.Interface.UserService;
//UserServiceImpl.java
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
 private UserRepository userRepository;

 public UserServiceImpl(UserRepository userRepository) {
     this.userRepository = userRepository;
 }

 @Override
 public User createUser(User user) {
     return userRepository.save(user);
 }

 @Override
 public User getUserById(Long id) {
     return userRepository.findById(id)
             .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
 }

 @Override
 public List<User> getAllUsers() {
     return userRepository.findAll();
 }

 @Override
 public void deleteUser(Long id) {
     if (!userRepository.existsById(id)) {
         throw new UserNotFoundException("User not found with id: " + id);
     }
     userRepository.deleteById(id);
 }
}