package com.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.dto.UserDTO;
import com.api.entity.User;
import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User , Long>{
	
	
	@Modifying
    @Transactional
	@Query( value = " UPDATE onlinelearning.user\r\n"
			+ "SET onlinelearning.user.course_id = NULL\r\n"
			+ "WHERE onlinelearning.user.course_id = ?1",nativeQuery = true)
	void deleteCourseId(Long courseId) ;

	User findByEmail(String email);
		
	
	

}
