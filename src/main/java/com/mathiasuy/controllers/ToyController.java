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

import com.mathiasuy.exceptions.ServicesException;
import com.mathiasuy.model.Toy;
import com.mathiasuy.requests.ToyRequest;
import com.mathiasuy.responses.ToyResponse;
import com.mathiasuy.services.IToyServices;

@RestController
public class ToyController {

	@Autowired
	private IToyServices toyServices;
	
	@PostMapping("/toy/add")
	public void addPet(@RequestBody ToyRequest toy) throws ServicesException {
		toyServices.add(toy);
	}
	
	@GetMapping("/toy/get/{id}")
	public ToyResponse getPet(@PathVariable("id") String name) throws ServicesException {
		return toyServices.get(name);
	}
	
	@DeleteMapping("/toy/delete/{id}")
	public void deletePet(@PathParam("id") String name) throws ServicesException {
		toyServices.delete(name);
	}
	
	@PutMapping("/toy/update")
	public void updatePet(@RequestBody ToyRequest toy) throws ServicesException {
		toyServices.update(toy);
	}
	
	@GetMapping("/toy/list")
	public List<Toy> listAll() {
		return toyServices.listAll();
	}
	
}
