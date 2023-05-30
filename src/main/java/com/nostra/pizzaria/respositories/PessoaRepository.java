package com.nostra.pizzaria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.pizzaria.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
