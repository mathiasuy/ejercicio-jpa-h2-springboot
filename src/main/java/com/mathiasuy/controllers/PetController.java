package com.mathiasuy.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathiasuy.exceptions.PetNotFound;
import com.mathiasuy.exceptions.ServicesException;
import com.mathiasuy.requests.PetRequest;
import com.mathiasuy.responses.PetResponse;
import com.mathiasuy.services.IPetServices;

@RestController
public class PetController {

	@Autowired
	private IPetServices petServices;
	
	/**
	 * Retorna el id del nuevo perro
	 * @param name
	 * @param age
	 * @return
	 */
	@PostMapping("/pet/add")
	public Long addPet(@RequestBody PetRequest pet) {
		return petServices.addPet(pet);
	}
	
	/**
	 * Retorna la mascota con el id solicitado
	 * @param id
	 * @return
	 * @throws PetNotFound 
	 */
	@GetMapping("/pet/get/{id}")
	public PetResponse getPet(@PathVariable("id") Long id) throws ServicesException {
		return petServices.getPet(id);
	}
	
	/**
	 * Retorna la mascota con el id solicitado
	 * @param id
	 * @return
	 * @throws PetNotFound 
	 */
	@DeleteMapping("/pet/delete/{id}")
	public void deletePet(@PathParam("id") Long id) throws ServicesException {
		petServices.deletePet(id);
	}
	
	/**
	 * Retorna la mascota con el id solicitado
	 * @param id
	 * @return
	 * @throws PetNotFound 
	 */
	@PutMapping("/pet/update")
	public void updatePet(@RequestBody PetRequest pet) throws ServicesException {
		petServices.updatePet(pet);
	}
	
	/**
	 * Retorna la mascota con el id solicitado
	 * @param id
	 * @return 
	 * @return
	 * @throws PetNotFound 
	 */
	@GetMapping("/pet/list")
	public List<PetResponse> listAll() {
		return petServices.listAllPets();
	}
	
}
