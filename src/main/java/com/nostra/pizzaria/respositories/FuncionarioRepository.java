package com.nostra.pizzaria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.pizzaria.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
