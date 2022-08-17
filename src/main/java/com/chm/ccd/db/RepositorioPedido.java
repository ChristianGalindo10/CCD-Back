package com.chm.ccd.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chm.ccd.model.Pedido;

public interface RepositorioPedido extends JpaRepository<Pedido, Integer>{
	
	@Query(value = "SELECT * FROM pedido WHERE pk_identificador=:id", nativeQuery = true)
	List<Pedido> findPedidosById(@Param("id") Long id);
	
	@Query(value = "SELECT pedido.* FROM pedido INNER JOIN pedido_restaurante "
			+ "ON pedido.pk_idpedido=pedido_restaurante.pk_idpedido "
			+ "WHERE pedido_restaurante.pk_nit=:nit", nativeQuery = true)
	List<Pedido> findPedidosByNit(@Param("nit") Long nit);
}
