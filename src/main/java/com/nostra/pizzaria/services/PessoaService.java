package com.nostra.pizzaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nostra.pizzaria.entities.Pessoa;
import com.nostra.pizzaria.respositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> findAll(){
		return repository.findAll();
	}

	public Pessoa findById(Long id) {
		repository.findById(id);
		Optional<Pessoa> p = repository.findById(id);
		return p.get();
		
	}
	
	public Pessoa cadastrar(Pessoa p) {
		return repository.save(p);
	}
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	public Pessoa atualizar(Long id, Pessoa p) {
		Pessoa entity = repository.getReferenceById(id);
		 atualizarDados(entity, p);
		 return repository.save(entity);
		 
	}

	private void atualizarDados(Pessoa entity, Pessoa p) {
		entity.setNome(p.getNome());
		entity.setIdade(p.getIdade());
		entity.setSenha(p.getSenha());
		entity.setTelefone(p.getTelefone());
		entity.setEmail(p.getEmail());
		
	}
}
