package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Integer>{

}
