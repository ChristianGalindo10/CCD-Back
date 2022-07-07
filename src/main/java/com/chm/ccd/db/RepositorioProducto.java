package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Producto;

public interface RepositorioProducto extends JpaRepository<Producto, Integer>{

}
