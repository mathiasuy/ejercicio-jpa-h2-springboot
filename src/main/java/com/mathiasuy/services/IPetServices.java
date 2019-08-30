package com.mathiasuy.services;

import java.util.List;

import com.mathiasuy.exceptions.PetNotFound;
import com.mathiasuy.requests.PetRequest;
import com.mathiasuy.responses.PetResponse;

public interface IPetServices {

	Long addPet(PetRequest petRequest);

	PetResponse getPet(Long id) throws PetNotFound;

	void deletePet(Long id) throws PetNotFound;

	void updatePet(PetRequest pet) throws PetNotFound;

	List<PetResponse> listAllPets();

}
