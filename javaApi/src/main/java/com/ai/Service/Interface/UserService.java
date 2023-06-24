package com.ai.Service.Interface;

import java.util.List;

import com.ai.EntityClasses.User;

//UserService.java
public interface UserService {
 User createUser(User user);
 User getUserById(Long id);
 List<User> getAllUsers();
 void deleteUser(Long id);
}