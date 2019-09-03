package com.mathiasuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathiasuy.model.Toy;

public interface IToyRepository  extends JpaRepository<Toy, String>{

}
