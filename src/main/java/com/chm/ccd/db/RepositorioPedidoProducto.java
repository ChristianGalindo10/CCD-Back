package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.ids.Pedido_Producto_Id;
import com.chm.ccd.model.Pedido_Producto;

public interface RepositorioPedidoProducto extends JpaRepository<Pedido_Producto, Pedido_Producto_Id>{

}
