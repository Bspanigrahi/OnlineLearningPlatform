package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.entity.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer , String> {

}
