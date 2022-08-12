package com.chm.ccd.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chm.ccd.db.RepositorioIngrediente;
import com.chm.ccd.model.Ingrediente;
import com.chm.ccd.security.dto.Message;
import com.chm.ccd.service.ServicioIngrediente;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "ingredientes")

public class ControladorIngrediente {
	
	@Autowired
	private RepositorioIngrediente repositorioIngrediente;
	
    @Autowired
    ServicioIngrediente ingredientService;
	
	@GetMapping("/get")
	public List<Ingrediente> getIngredients() {
		return repositorioIngrediente.findAll();
	}
	@PostMapping("/newingredient")
	public ResponseEntity<?> nuevoIngrediente(@Valid @RequestBody Ingrediente nuevoIngrediente ,BindingResult bindingResult){
		if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
		if(ingredientService.existsByNombre(nuevoIngrediente.getNombre()))
			return new ResponseEntity(new Message("That name already exists, you must create a name"), HttpStatus.BAD_REQUEST);
		Ingrediente ingrediente =
                new Ingrediente(nuevoIngrediente.getUnidades(),nuevoIngrediente.getUnidadMedida(),nuevoIngrediente.getNombre());
	/*	Usuario nuevoUsuario = new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),usuario.getPassword(),usuario.getEmail());*/
		ingredientService.save(ingrediente);
		return new ResponseEntity<Message>(new Message("Ingrediente guardado"), HttpStatus.CREATED);
	}
	/*@PostMapping("/add")
	public ResponseEntity<?> createIngredient(@RequestBody Ingrediente ingrediente) throws IOException {
		Ingrediente nuevoIngrediente =
                new Ingrediente(ingrediente.getUnidades(),ingrediente.getUnidadMedida(),ingrediente.getNombre());
		Usuario nuevoUsuario = new Usuario(usuario.getName(),usuario.getCelular(),usuario.getTipo(),usuario.getPassword(),usuario.getEmail());
		repositorioIngrediente.save(nuevoIngrediente);
		return new ResponseEntity<Message>(new Message("Ingrediente guardado"), HttpStatus.CREATED);
	}*/


}
