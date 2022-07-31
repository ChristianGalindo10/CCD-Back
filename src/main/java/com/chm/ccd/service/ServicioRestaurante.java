package com.chm.ccd.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioRestaurante;
import com.chm.ccd.model.Restaurante;

@Service
@Transactional
public class ServicioRestaurante {
	
	@Autowired
    RepositorioRestaurante restaurantRepository;
	
	public Optional<Restaurante> getByEmail(String email){
        return restaurantRepository.findByEmail(email);
    }
	
	public boolean existsByEmail(String email) {
		return restaurantRepository.existsByEmail(email);
	}
	
	public boolean existsByNit(Long nit) {
		return restaurantRepository.existsByNit(nit);
	}
	
	public void save(Restaurante restaurante){
		restaurantRepository.save(restaurante);
    }
}
