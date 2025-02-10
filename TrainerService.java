package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.dto.TrainerDTO;
import com.api.entity.Trainer;
import com.api.repository.TrainerRepo;

@Service
public class TrainerService {
	
	@Autowired
	private TrainerRepo trainerrepo;

	public Trainer addTrainer(Trainer trainer) {
		
        Trainer savetrainer = trainerrepo.save(trainer);
		
		return savetrainer;
	}
	

	public List<TrainerDTO> getTrainer() {
		
		 
		 List<Trainer> trainerlist = trainerrepo.findAll();
		 List<TrainerDTO> gettrainer = new ArrayList<>();
		 
		 for(Trainer trainer:trainerlist) {
			 TrainerDTO trainerDTO = new TrainerDTO();
			 trainerDTO.setId(trainer.getId());
			 trainerDTO.setName(trainer.getName());
			 trainerDTO.setSubject(trainer.getSubject());
			 trainerDTO.setQualification(trainer.getQualification());
			 trainerDTO.setEmail(trainer.getEmail());
			 
			 gettrainer.add(trainerDTO);
		 }
		 
		
		return gettrainer;
	}


	public void deleteTrainer(String id) {
	    
	    Optional<Trainer> trainer = trainerrepo.findById(id);
	    
	    
	    trainerrepo.deleteById(id);
	}



	public TrainerDTO updateTrainer(String id, TrainerDTO trainerDTO) {
		
		 
		        
		        Trainer existingTrainer = trainerrepo.findById(id).orElse(null);
		        
		        if (existingTrainer == null) {
		             System.out.println("Trainer with ID " + id + " not found");
		        }

		        existingTrainer.setId(trainerDTO.getId());
		        existingTrainer.setName(trainerDTO.getName());
		        existingTrainer.setSubject(trainerDTO.getSubject());
		        existingTrainer.setSubject(trainerDTO.getQualification());
		        existingTrainer.setEmail(trainerDTO.getEmail());
		        
		        
		        
		        Trainer updatedTrainer = trainerrepo.save(existingTrainer);

		        
		        TrainerDTO updatedTrainerDTO = new TrainerDTO();
		        updatedTrainerDTO.setId(updatedTrainer.getId());
		        updatedTrainerDTO.setName(updatedTrainer.getName());
		        updatedTrainerDTO.setSubject(updatedTrainer.getSubject());
		        updatedTrainerDTO.setQualification(updatedTrainer.getQualification());
		        updatedTrainerDTO.setEmail(updatedTrainer.getEmail());
		       
		        

		        
		        return updatedTrainerDTO; 
		    }
	


}
