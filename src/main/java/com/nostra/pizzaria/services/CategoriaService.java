package com.nostra.pizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nostra.pizzaria.entities.Categoria;
import com.nostra.pizzaria.respositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll(){
		return repository.findAll();
	}

	public Categoria findById(Long id) {
		repository.findById(id);
		Optional<Categoria> p = repository.findById(id);
		return p.get();
	}
}
