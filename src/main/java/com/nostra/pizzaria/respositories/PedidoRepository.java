package com.nostra.pizzaria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nostra.pizzaria.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
