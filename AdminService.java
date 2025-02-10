package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.AdminDTO;
import com.api.entity.Admin;
import com.api.entity.User;
import com.api.repository.AdminRepo;

@Service
public class AdminService {
	
	
	@Autowired
	private  AdminRepo adminrepo;
	


	

	public Admin addAdmin(Admin adminn) {
	    Admin admin = new Admin();
	    
	    
	    admin.setName(adminn.getName());
	    admin.setEmail(adminn.getEmail());  
	    admin.setPassword(adminn.getPassword());  

	    
	    return adminrepo.save(admin);
	}





    public Admin validateAdmin(String email, String password) {
	    
	    Admin admin = adminrepo.findByEmail(email); 

	   
	    if (admin != null && admin.getPassword().equals(password)) {
	        return admin;
	    }

	    return null; 
	    
    }

}
