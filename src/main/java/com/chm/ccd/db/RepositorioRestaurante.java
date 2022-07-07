package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Restaurante;

public interface RepositorioRestaurante extends JpaRepository<Restaurante, Integer>{

}
