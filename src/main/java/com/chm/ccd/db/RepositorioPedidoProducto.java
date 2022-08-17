package com.chm.ccd.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chm.ccd.ids.Pedido_Producto_Id;
import com.chm.ccd.model.Pedido_Producto;

public interface RepositorioPedidoProducto extends JpaRepository<Pedido_Producto, Pedido_Producto_Id>{
	
	@Query(value = "SELECT * FROM pedido_producto WHERE pk_idpedido=:idp AND pk_idproducto=:pid", nativeQuery = true)
	Optional<Pedido_Producto> findByIdProducto(int idp,Integer pid);
}
