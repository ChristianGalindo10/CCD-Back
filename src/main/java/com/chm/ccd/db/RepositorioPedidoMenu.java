package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.ids.Pedido_Menu_Id;
import com.chm.ccd.model.Pedido_Menu;

public interface RepositorioPedidoMenu extends JpaRepository<Pedido_Menu, Pedido_Menu_Id>{

}
