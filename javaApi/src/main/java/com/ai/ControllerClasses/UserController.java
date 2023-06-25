package com.ai.ControllerClasses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.EntityClasses.User;
import com.ai.Service.Interface.UserService;

//UserController.java
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
 private UserService userService;

 public UserController(UserService userService) {
     this.userService = userService;
 }

 @PostMapping
 public ResponseEntity<User> createUser(@RequestBody User user) {
     User createdUser = userService.createUser(user);
     return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
 }

 @GetMapping("/{id}")
 public ResponseEntity<User> getUserById(@PathVariable Long id) {
     User user = userService.getUserById(id);
     if (user != null) {
         return ResponseEntity.ok(user);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

 @GetMapping
 public ResponseEntity<List<User>> getAllUsers() {
     List<User> users = userService.getAllUsers();
     return ResponseEntity.ok(users);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
     userService.deleteUser(id);
     return ResponseEntity.noContent().build();
 }
}
