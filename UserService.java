package com.api.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.dto.CourseDTO;
import com.api.dto.UserDTO;
import com.api.entity.Course;
import com.api.entity.User;
import com.api.repository.CourseRepo;
import com.api.repository.UserRepo;

@Service
public class UserService {

	
	@Autowired
	private  UserRepo userrepo;
	
	@Autowired
	private  CourseRepo courserepo;
	


	public User addUser(UserDTO userdto) {
		
	Course course = courserepo.findById(userdto.getCourseId())
			.orElseThrow(() -> new RuntimeException("Course not found"));

	 User user = new User();
     user.setName(userdto.getName());
     user.setEmail(userdto.getEmail());
     user.setPassword(userdto.getPassword());
     user.setCourse(course); 

     return userrepo.save(user);
		
	   
	}

	public List<UserDTO> fetchUser() {
		 List<User> userList = userrepo.findAll(); 
		 List<UserDTO> getuser = new ArrayList<>();
		 
		 for(User user:userList) {
			 UserDTO  userDTO = new UserDTO();
			 userDTO.setId(user.getId());
			 userDTO.setName(user.getName());
		     userDTO.setEmail(user.getEmail());
		     userDTO.setPassword(user.getPassword());
		     userDTO.setCourseId(user.getId());
		     
		     if (user.getCourse() != null) {
		            userDTO.setCourseId(user.getCourse().getCourseId()); 
		        }
		     
		     getuser.add(userDTO);
		     
		 }
		 
		 return getuser;
		
	}
	

	public UserDTO getUser(Long id) {
		
		User user = userrepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
		
		UserDTO userDTO = new UserDTO();
	    userDTO.setId(user.getId());
	    userDTO.setName(user.getName());
	    userDTO.setEmail(user.getEmail());
	    userDTO.setPassword(user.getPassword());

	    if (user.getCourse() != null) {
	        userDTO.setCourseId(user.getCourse().getCourseId());
	    }

	    return userDTO;

	}

	
	
	public UserDTO deleteUser(Long id) {
        
        User user = userrepo.findById(id).orElse(null);
        
       
        
       
        UserDTO deletedUserDTO = new UserDTO();
        deletedUserDTO.setId(user.getId());
        deletedUserDTO.setName(user.getName());
        deletedUserDTO.setEmail(user.getEmail());
        deletedUserDTO.setPassword(user.getPassword());
        deletedUserDTO.setCourse(user.getCourse());
        
        
        userrepo.delete(user);
        
        
        return deletedUserDTO;
    }

	
	public User updateUser(Long id,UserDTO userDTO) {
      
        User user = userrepo.findById(id).orElseThrow(() -> new RuntimeException("User not found" + id));

                Course course = courserepo.findById(userDTO.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"  + userDTO.getCourseId()));

        
        user.setName(userDTO.getName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setCourse(course);

        
        return userrepo.save(user);
    }

	
	
	public User validateUser(String email, String password) {
	    
	    User user = userrepo.findByEmail(email); 

	   
	    if (user != null && user.getPassword().equals(password)) {
	        return user;
	    }

	    return null; 
	}
	
	
	
	
	
    public User getLoginUserInfo(String userEmail) {
		
		return userrepo.findByEmail(userEmail);
	}

}
