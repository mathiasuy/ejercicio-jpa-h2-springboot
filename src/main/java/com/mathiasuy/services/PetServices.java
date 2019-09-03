	package com.mathiasuy.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathiasuy.exceptions.PetNotFound;
import com.mathiasuy.model.Cat;
import com.mathiasuy.model.Dog;
import com.mathiasuy.model.Pet;
import com.mathiasuy.model.Toy;
import com.mathiasuy.repository.IPetRepository;
import com.mathiasuy.repository.IToyRepository;
import com.mathiasuy.requests.CatRequest;
import com.mathiasuy.requests.DogRequest;
import com.mathiasuy.requests.PetRequest;
import com.mathiasuy.responses.PetResponse;

@Service
public class PetServices implements IPetServices {

	@Autowired
	private IPetRepository petRepository;
	
	@Autowired
	private IToyRepository toyRepository;
	
	@Override
	public PetResponse getPet(Long id) throws PetNotFound {
		Pet pet = petRepository.findById(id).orElseThrow(() -> new PetNotFound(id));
		return pet.getResponse();
	}

	@Override
	public Long addPet(PetRequest petRequest) {
		Pet pet;
		if (petRequest instanceof DogRequest) {
			DogRequest dogRequest = (DogRequest)petRequest;
			pet = new Dog(dogRequest.getName(), dogRequest.getAge());
		}else {
			CatRequest catRequest = (CatRequest)petRequest;
			pet = new Cat(catRequest.getName(), catRequest.getAge(), catRequest.getHair());
		} 
		pet.setToys(petRequest.getToys().stream().map(t -> new Toy(t.getName(), t.getDescription())).collect(Collectors.toList()));
		
		pet.getToys().forEach(t -> {
			if (!toyRepository.existsById(t.getName())) {
				toyRepository.save(t);
			}
		});
		petRepository.save(pet);
		return pet.getId();
	}

	@Override
	public void deletePet(Long id) throws PetNotFound {
		if (petRepository.existsById(id)) {
			petRepository.deleteById(id);
		}
		throw new PetNotFound(id);
	}

	@Override
	public void updatePet(PetRequest pet) throws PetNotFound {
		Pet petModel = petRepository.findById(pet.getId()).orElseThrow(() -> new PetNotFound(pet.getId()));
		petModel.setParameters(pet);
	}

	@Override
	public List<PetResponse> listAllPets() {
		List<Pet> list = petRepository.findAll();
		return list.stream().map(p -> p.getResponse()).collect(Collectors.toList()); 
	}

}
