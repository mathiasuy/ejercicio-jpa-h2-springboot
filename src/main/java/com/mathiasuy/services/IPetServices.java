package com.mathiasuy.services;

import java.util.List;

import com.mathiasuy.exceptions.PetNotFound;
import com.mathiasuy.exceptions.ServicesException;
import com.mathiasuy.requests.PetRequest;
import com.mathiasuy.responses.PetResponse;

public interface IPetServices {

	Long addPet(PetRequest petRequest);

	PetResponse getPet(Long id) throws ServicesException;

	void deletePet(Long id) throws ServicesException;

	void updatePet(PetRequest pet) throws ServicesException;

	List<PetResponse> listAllPets();

}
