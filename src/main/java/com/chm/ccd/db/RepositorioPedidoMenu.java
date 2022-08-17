package com.chm.ccd.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chm.ccd.ids.Pedido_Menu_Id;
import com.chm.ccd.model.Pedido_Menu;

public interface RepositorioPedidoMenu extends JpaRepository<Pedido_Menu, Pedido_Menu_Id>{
	
	@Query(value = "SELECT * FROM pedido_menu WHERE pk_idpedido=:pid AND pk_idmenu=:mid", nativeQuery = true)
	Optional<Pedido_Menu> findByIdMenu(Integer pid, int mid);
}
