package com.nostra.pizzaria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.pizzaria.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
