package com.chm.ccd.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chm.ccd.model.Menu;

public interface RepositorioMenu extends JpaRepository<Menu, Integer>{
	
	@Query(value = "SELECT * FROM menu WHERE pk_nit=:nit", nativeQuery = true)
	List<Menu> findMenusByNit(@Param("nit") Long nit);
	
	@Query(value = "SELECT menu.* FROM menu INNER JOIN pedido_menu "
			+ "ON menu.pk_idmenu=pedido_menu.pk_idmenu "
			+ "WHERE pedido_menu.pk_idpedido=:idp", nativeQuery = true)
	List<Menu> findMenusByPedido(@Param("idp") int idp);

}
