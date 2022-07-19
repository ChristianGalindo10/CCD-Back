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
import com.chm.ccd.security.dto.UserLogin;

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
		Usuario nuevoUsuario =
                new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),passwordEncoder.encode(usuario.getPassword()),usuario.getEmail());
	/*	Usuario nuevoUsuario = new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),usuario.getPassword(),usuario.getEmail());*/
		repositorioUsuario.save(nuevoUsuario);
		return new ResponseEntity<Message>(new Message("Usuario guardado"), HttpStatus.CREATED);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<?> Login(@RequestBody UserLogin usuarioLogin) throws IOException{
		if(existsByEmail(usuarioLogin.getEmail())) {
            return new ResponseEntity(new Message("El usuario ya esta registrado"), HttpStatus.OK);
		}else {
            return new ResponseEntity(new Message("El usuario no esta registrado"), HttpStatus.OK);
		}
	}
    public boolean existsByEmail(String email){
        return repositorioUsuario.existsByEmail(email);
    }
	
	

}