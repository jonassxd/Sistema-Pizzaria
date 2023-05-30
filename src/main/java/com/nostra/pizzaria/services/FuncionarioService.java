package com.nostra.pizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nostra.pizzaria.entities.Funcionario;
import com.nostra.pizzaria.respositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;

	public List<Funcionario> findAll(){
		return repository.findAll();
	}

	public Funcionario findById(Long id) {
		repository.findById(id);
		Optional<Funcionario> f = repository.findById(id);
		return f.get();
	}
}
