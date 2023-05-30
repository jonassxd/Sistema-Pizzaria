package com.nostra.pizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nostra.pizzaria.entities.Produto;
import com.nostra.pizzaria.respositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll(){
		return repository.findAll();
	}

	public Produto findById(Long id) {
		repository.findById(id);
		Optional<Produto> p = repository.findById(id);
		return p.get();
	}
}
