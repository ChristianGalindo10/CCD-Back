package com.chm.ccd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chm.ccd.db.RepositorioUsuario;
import com.chm.ccd.model.Usuario;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "usuarios")

public class ControladorUsuario {

	@Autowired
	private RepositorioUsuario controladorUsuario;
	
	@GetMapping("/get")
	public List<Usuario> getUsers() {
		return controladorUsuario.findAll();
	}

}