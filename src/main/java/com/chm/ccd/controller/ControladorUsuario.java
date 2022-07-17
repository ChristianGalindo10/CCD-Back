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
import org.springframework.security.crypto.password.PasswordEncoder;


import com.chm.ccd.db.RepositorioUsuario;
import com.chm.ccd.model.Usuario;
import com.chm.ccd.security.dto.Message;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "usuarios")

public class ControladorUsuario {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
    PasswordEncoder passwordEncoder;

	
	@GetMapping("/get")
	public List<Usuario> getUsers() {
		return repositorioUsuario.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> createUser(@RequestBody Usuario usuario) throws IOException {
		/*Usuario nuevoUsuario =
                new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),passwordEncoder.encode(usuario.getPassword()));*/
		Usuario nuevoUsuario = new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),usuario.getPassword());
		repositorioUsuario.save(nuevoUsuario);
		return new ResponseEntity<Message>(new Message("Usuario guardado"), HttpStatus.CREATED);
	}

}