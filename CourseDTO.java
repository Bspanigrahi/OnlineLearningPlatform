package com.api.dto;

import java.util.List;

import com.api.entity.User;

public class CourseDTO {

     
    private Long courseId;
    private String courseName;
    private String trainerName;
    private Long price;
    
    private List<UserDTO> users;

	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
    
    
}
