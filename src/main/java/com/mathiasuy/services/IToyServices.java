package com.mathiasuy.services;

import java.util.List;

import com.mathiasuy.exceptions.ServicesException;
import com.mathiasuy.model.Toy;
import com.mathiasuy.requests.ToyRequest;
import com.mathiasuy.responses.ToyResponse;

public interface IToyServices {

	void add(ToyRequest toy) throws ServicesException;

	ToyResponse get(String name) throws ServicesException;

	List<Toy> listAll();

	void update(ToyRequest toy) throws ServicesException;

	void delete(String name) throws ServicesException;

}
