package com.chm.ccd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chm.ccd.db.RepositorioRestaurante;
import com.chm.ccd.db.RepositorioRestauranteProducto;
import com.chm.ccd.model.Restaurante;
import com.chm.ccd.model.Restaurante_Producto;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "restaurantes")
public class ControladorRestaurante {

	@Autowired
	private RepositorioRestaurante repositorioRestaurante;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
    RepositorioRestauranteProducto restaurantProductRepository;
	
	@GetMapping("/get")
	public List<Restaurante> getRestaurantes() {
		return repositorioRestaurante.findAll();
	}
	
	@GetMapping("/getAllProducts")
	public List<Restaurante_Producto> getRestaurantesProductos() {
		return restaurantProductRepository.findAll();
	}
	

	
	/*
	@PostMapping("/add")
	public ResponseEntity<?> createUser(@RequestBody Restaurante restaurante) throws IOException {
		Restaurante nuevoRestaurante =
                new Restaurante(restaurante.getNit(),restaurante.getNombre(),restaurante.getTelefono(),restaurante.getEspecialidad(),restaurante.getEmail(),passwordEncoder.encode(restaurante.getPassword()));
		repositorioRestaurante.save(nuevoRestaurante);
		return new ResponseEntity<Message>(new Message("Restaurante guardado"), HttpStatus.CREATED);
	}*/
}
