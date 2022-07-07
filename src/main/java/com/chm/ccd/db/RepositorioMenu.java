package com.chm.ccd.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Menu;

public interface RepositorioMenu extends JpaRepository<Menu, Integer>{

}
