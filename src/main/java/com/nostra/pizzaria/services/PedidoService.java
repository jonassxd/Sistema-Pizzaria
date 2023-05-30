package com.nostra.pizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nostra.pizzaria.entities.Pedido;
import com.nostra.pizzaria.respositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	public List<Pedido> findAll(){
		return repository.findAll();
	}

	public Pedido findById(Long id) {
		repository.findById(id);
		Optional<Pedido> p = repository.findById(id);
		return p.get();
	}
}
