package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dto.CourseDTO;
import com.api.dto.TrainerDTO;
import com.api.dto.UserDTO;
import com.api.entity.Course;
import com.api.entity.Trainer;
import com.api.entity.User;
import com.api.repository.CourseRepo;
import com.api.repository.UserRepo;

@Service
public class CourseService {
    
	@Autowired
	private CourseRepo courserepo;
	
	@Autowired
	private UserRepo userrepo;

	public Course addCourse(Course course) {
		
		Course savecourse = courserepo.save(course);
		
		return savecourse;
	}
	

	
	public List<CourseDTO> getAllCourse() {
		
		List<Course> courselist = courserepo.findAll();
		List<CourseDTO> getcourse = new ArrayList<>();
		
		
		 for(Course course : courselist) {
			 
			 CourseDTO  courseDTO = new CourseDTO();
			 courseDTO.setCourseId(course.getCourseId());
			 courseDTO.setCourseName(course.getCourseName());
		     courseDTO.setTrainerName(course.getTrainerName());
		     courseDTO.setPrice(course.getPrice());
		     
		     
		     List<UserDTO> userDTOList = new ArrayList<>();
		     if (course.getUsers() != null && !course.getUsers().isEmpty()) {
		    	 for (User user : course.getUsers()) {
		                UserDTO userDTO = new UserDTO();
		                userDTO.setId(user.getId());
		                userDTO.setName(user.getName());
		                userDTO.setEmail(user.getEmail());
		                userDTO.setPassword(user.getPassword());
		               
		                if (user.getCourse() != null) {
		                    userDTO.setCourseId(user.getCourse().getCourseId()); 
		                } else {
		                    userDTO.setCourseId(null); 
		                }
		                
		                userDTOList.add(userDTO);
		            }
		        }
		     courseDTO.setUsers(userDTOList);
		     getcourse.add(courseDTO);
		     
		 }
		 
		 return getcourse;
		
		
	}



	public CourseDTO getCourse(Long id) {
		
		Course course = courserepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
		
		
		CourseDTO courseDTO = new CourseDTO();
	    courseDTO.setCourseId(course.getCourseId());
	    courseDTO.setCourseName(course.getCourseName());
	    courseDTO.setTrainerName(course.getTrainerName());
	    courseDTO.setPrice(course.getPrice());
		
	    List<UserDTO> userDTOList = new ArrayList<>();
	    
	    if (course.getUsers() != null && !course.getUsers().isEmpty()) {
	        for (User user : course.getUsers()) {
	            UserDTO userDTO = new UserDTO();
	            userDTO.setId(user.getId());
	            userDTO.setName(user.getName());
	            userDTO.setEmail(user.getEmail());
	            userDTO.setPassword(user.getPassword());
	            
	            
	            if (user.getCourse() != null) {
	                userDTO.setCourseId(user.getCourse().getCourseId());
	            } else {
	                userDTO.setCourseId(null);
	            }     
	
	            userDTOList.add(userDTO);
	   }
	        
	        
	        
	    }
	    
	    courseDTO.setUsers(userDTOList);
	    return courseDTO;
	
}



	public CourseDTO deleteCourse(Long id) {
		
		Course course = courserepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));

		
		 userrepo.deleteCourseId(course.getCourseId());  
		 courserepo.delete(course);
		 
		 CourseDTO courseDTO = new CourseDTO();
		    courseDTO.setCourseId(course.getCourseId());
		    courseDTO.setCourseName(course.getCourseName());
		    courseDTO.setTrainerName(course.getTrainerName());
		    courseDTO.setPrice(course.getPrice());
		    
		    return courseDTO; 
	}



	public CourseDTO updateCourseById(Long id,CourseDTO coursedto) {
		
		 Course existingCourse = courserepo.findById(id).orElse(null);
	        
	        if (existingCourse == null) {
	             System.out.println("Trainer with ID " + id + " not found");
	        }

	        existingCourse.setCourseId(coursedto.getCourseId());
	        existingCourse.setCourseName(coursedto.getCourseName());
	        existingCourse.setTrainerName(coursedto.getTrainerName());
	        existingCourse.setPrice(coursedto.getPrice());
	        
	        
	        
	        Course updatedCourse = courserepo.save(existingCourse);

	        
	        CourseDTO updatedCourseDTO = new CourseDTO();
	        updatedCourseDTO.setCourseId(updatedCourse.getCourseId());
	        updatedCourseDTO.setCourseName(updatedCourse.getCourseName());
	        updatedCourseDTO.setTrainerName(updatedCourse.getTrainerName());
	        updatedCourseDTO.setPrice(updatedCourse.getPrice());
	        

	        
	        return updatedCourseDTO; 
	}
	
	
}
