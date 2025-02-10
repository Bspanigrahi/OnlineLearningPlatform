package com.api.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
    private Long courseId;
    
    private String courseName;
    private String trainerName;
    private Long price;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users;
    
    
    

	


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


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
    
	
	
    
}
