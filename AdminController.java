package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.AdminDTO;
import com.api.entity.Admin;
import com.api.entity.User;
import com.api.service.AdminService;

import jakarta.servlet.http.HttpSession;

@RestController
public class AdminController {
      
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@Autowired
	private AdminService adminservice; 
	
	
	@PostMapping("/adddata")
	public Admin addAdmin(@RequestBody Admin adminn) {
		
		return this.adminservice.addAdmin(adminn);
	}
	
	
	 @PostMapping("/loginadmin")
	 public Admin login(@RequestParam String email, @RequestParam String password, HttpSession session) {
	     Admin admin = adminservice.validateAdmin(email, password); 
	     
	     return adminservice.validateAdmin(email, password); 

	 }
	
	
	
}
