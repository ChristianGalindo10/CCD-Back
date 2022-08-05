package com.chm.ccd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioIngrediente;
import com.chm.ccd.model.Ingrediente;

@Service
public class ServicioIngrediente {
	@Autowired
    RepositorioIngrediente ingredientRepository;
	
	public boolean existsByNombre(String nombre){
        return ingredientRepository.existsByNombre(nombre);
    }
	
	public void save(Ingrediente ingrediente){
		ingredientRepository.save(ingrediente);
    }
	
	public Optional<Ingrediente> getByName(String name){
		return ingredientRepository.findByNombre(name);
	}

}
