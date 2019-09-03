package com.mathiasuy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathiasuy.exceptions.AlreadyExists;
import com.mathiasuy.exceptions.ToyNotFound;
import com.mathiasuy.model.Toy;
import com.mathiasuy.repository.IToyRepository;
import com.mathiasuy.requests.ToyRequest;
import com.mathiasuy.responses.ToyResponse;

@Service
public class ToyServices implements IToyServices {

	@Autowired
	private IToyRepository toyRepository;
	
	@Override
	public void add(ToyRequest toy) throws AlreadyExists {
		if (toyRepository.existsById(toy.getName())) {
			throw new AlreadyExists(toy.getName());
		}
		toyRepository.save(new Toy(toy.getName(),toy.getDescription()));
	}

	@Override
	public ToyResponse get(String name) throws ToyNotFound {
		if (!toyRepository.existsById(name)) {
			throw new ToyNotFound(name);
		}
		Toy toy = toyRepository.getOne(name);
		return new ToyResponse(toy.getName(), toy.getDescription());
	}

	@Override
	public List<Toy> listAll() {
		return toyRepository.findAll();
	}

	@Override
	public void update(ToyRequest toy) throws ToyNotFound {
		if (!toyRepository.existsById(toy.getName())) {
			throw new ToyNotFound(toy.getName());
		}
		Toy toyModel = toyRepository.getOne(toy.getName());
		toyModel.setDescription(toy.getDescription());
	}

	@Override
	public void delete(String name) throws ToyNotFound {
		if (!toyRepository.existsById(name)) {
			throw new ToyNotFound(name);
		}
		toyRepository.deleteById(name);
	}

}
