package com.chm.ccd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chm.ccd.db.RepositorioMenu;
import com.chm.ccd.model.Menu;

@Service
@Transactional
public class ServicioMenu {
	
	@Autowired
    RepositorioMenu menuRepository;
	
	public List<Menu> getMenusByNit(Long nit){
		return menuRepository.findMenusByNit(nit);
	}
	
	public List<Menu> getMenusByPedido(int idp){
		return menuRepository.findMenusByPedido(idp);
	}

}
