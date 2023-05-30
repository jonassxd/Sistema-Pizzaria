package com.nostra.pizzaria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.pizzaria.entities.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

}
