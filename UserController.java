package com.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.UserDTO;
import com.api.entity.Course;
import com.api.entity.User;
import com.api.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUser")
	public User createUser(@RequestBody UserDTO userdto) {
		
		return this.userservice.addUser(userdto);
	}
	
	
	@GetMapping("/getAllUser")
	public List<UserDTO> fetchUser(){
		
		return this.userservice.fetchUser();
	}
	
	@GetMapping("/getUser/{id}")
	public UserDTO getUser(@PathVariable Long id){
		
		return this.userservice.getUser(id);
	}
	
	 @PutMapping("/update/{userId}")
	  public User updateUser(@PathVariable("userId") Long id, @RequestBody UserDTO userDTO) {
	       
	         return userservice.updateUser(id ,userDTO);
	    }
	 
	 
	 

	
	
	  @PostMapping("/loginuser")
	 public User login(@RequestParam String email, @RequestParam String password, HttpSession session) {
	     
          return userservice.validateUser(email, password);

	 }
	 
	
	  
	  
	  
	 @GetMapping("/login-user-info")
	 public User getLoginUserInfo(@RequestParam String userEmail) {
	    
	    
		 return userservice.getLoginUserInfo(userEmail);
	 }

	 
	 
    @DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
	    
	    UserDTO deletedUserDTO = this.userservice.deleteUser(id);
	    
	    
	    return ResponseEntity.ok(deletedUserDTO);
	}


}