package com.chm.ccd.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chm.ccd.db.RepositorioRestaurante;
import com.chm.ccd.model.Restaurante;
import com.chm.ccd.security.dto.Message;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "restaurantes")
public class ControladorRestaurante {

	@Autowired
	private RepositorioRestaurante repositorioRestaurante;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@GetMapping("/get")
	public List<Restaurante> getRestaurantes() {
		return repositorioRestaurante.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> createUser(@RequestBody Restaurante restaurante) throws IOException {
		Restaurante nuevoRestaurante =
                new Restaurante(restaurante.getNit(),restaurante.getNombre(),restaurante.getTelefono(),restaurante.getEspecialidad(),restaurante.getEmail(),passwordEncoder.encode(restaurante.getPassword()));
	/*	Usuario nuevoUsuario = new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),usuario.getPassword(),usuario.getEmail());*/
		repositorioRestaurante.save(nuevoRestaurante);
		return new ResponseEntity<Message>(new Message("Restaurante guardado"), HttpStatus.CREATED);
	}
}
