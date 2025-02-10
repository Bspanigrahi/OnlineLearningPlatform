package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.TrainerDTO;
import com.api.entity.Trainer;
import com.api.service.TrainerService;


@RestController
public class TrainerController {

	@Autowired
	private TrainerService trainerservice;
	
	@PostMapping("/addTrainer")
	public Trainer addTrainer(@RequestBody Trainer trainer) {
		
		return trainerservice.addTrainer(trainer);
		
	}
	
	@GetMapping("/getTrainer")
	public List<TrainerDTO> getTrainer() {
		
		return trainerservice.getTrainer();
	}
	
	
	@PutMapping("/updateTrainer/{id}")
	public TrainerDTO updateTrainer(@PathVariable String id, @RequestBody TrainerDTO trainerDTO) {
	   
	    TrainerDTO updatedTrainerDTO = trainerservice.updateTrainer(id, trainerDTO);
	    
	    
	    return updatedTrainerDTO;
	}

	
	
	@DeleteMapping("/deleteTrainer/{id}")
	public ResponseEntity<String> deleteTrainer(@PathVariable String id) {
	    
	        
	        trainerservice.deleteTrainer(id);
	        
	     return ResponseEntity.ok("Trainer with ID " + id + " was successfully deleted.");
	    
	}

	
}
