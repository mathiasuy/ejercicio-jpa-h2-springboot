package com.mathiasuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathiasuy.model.Pet;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long>{
	
}
