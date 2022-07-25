package com.chm.ccd.controller;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chm.ccd.db.RepositorioIngrediente;
import com.chm.ccd.model.Ingrediente;
import com.chm.ccd.security.dto.Message;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "ingredientes")

public class ControladorIngrediente {
	
	@Autowired
	private RepositorioIngrediente repositorioIngrediente;
	
	@GetMapping("/get")
	public List<Ingrediente> getIngredients() {
		return repositorioIngrediente.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> createIngredient(@RequestBody Ingrediente ingrediente) throws IOException {
		Ingrediente nuevoIngrediente =
                new Ingrediente(ingrediente.getUnidades(),ingrediente.getUnidadMedida(),ingrediente.getNombre());
	/*	Usuario nuevoUsuario = new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),usuario.getPassword(),usuario.getEmail());*/
		repositorioIngrediente.save(nuevoIngrediente);
		return new ResponseEntity<Message>(new Message("Ingrediente guardado"), HttpStatus.CREATED);
	}


}
