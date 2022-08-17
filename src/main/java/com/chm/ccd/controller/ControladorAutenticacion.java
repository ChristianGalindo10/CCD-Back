package com.chm.ccd.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chm.ccd.model.Ingrediente;
import com.chm.ccd.model.Producto;
import com.chm.ccd.model.Restaurante;
import com.chm.ccd.model.Usuario;
import com.chm.ccd.security.dto.JwtDto;
import com.chm.ccd.security.dto.Message;
import com.chm.ccd.security.dto.UserLogin;
import com.chm.ccd.security.jwt.JwtProvider;
import com.chm.ccd.service.ServicioIngrediente;
import com.chm.ccd.service.ServicioProducto;
import com.chm.ccd.service.ServicioRestaurante;
import com.chm.ccd.service.ServicioUsuario;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://localhost:3000")
public class ControladorAutenticacion {
	@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    ServicioUsuario usuarioService;
    
    @Autowired
    ServicioRestaurante restaurantService;
    

    @Autowired
    JwtProvider jwtProvider;
    

    @PostMapping("/newuser")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody Usuario nuevoUsuario, BindingResult bindingResult){
        //if(bindingResult.hasErrors())
           // return new ResponseEntity(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Message("That name already exists, you must create a name"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getName(), nuevoUsuario.getCelular(), nuevoUsuario.getTipo(),
        				passwordEncoder.encode(nuevoUsuario.getPassword()), nuevoUsuario.getEmail());
        /*if(nuevoUsuario.getType().equals("admin"))
            usuario.setType("admin");*/
        usuarioService.save(usuario);
        return new ResponseEntity(new Message("usuario guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/newrestaurant")
    public ResponseEntity<?> nuevoRestaurante(@Valid @RequestBody Restaurante nuevoRestaurante, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(restaurantService.existsByEmail(nuevoRestaurante.getEmail()))
            return new ResponseEntity(new Message("That name already exists, you must create a name"), HttpStatus.BAD_REQUEST);
        if(restaurantService.existsByNit(nuevoRestaurante.getNit()))
            return new ResponseEntity(new Message("Este id ya existe"), HttpStatus.OK);
        Restaurante restaurante =
                new Restaurante(nuevoRestaurante.getNit(),nuevoRestaurante.getNombre(),nuevoRestaurante.getTelefono(),nuevoRestaurante.getEspecialidad(),nuevoRestaurante.getEmail(),passwordEncoder.encode(nuevoRestaurante.getPassword()));
        /*if(nuevoUsuario.getType().equals("admin"))
            usuario.setType("admin");*/
        restaurantService.save(restaurante);
        return new ResponseEntity(new Message("restaurante guardado"), HttpStatus.CREATED);
    }


    @PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLogin loginUsuario, BindingResult bindingResult) {
		//if (bindingResult.hasErrors())
			//return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Long id = (long) 0;
		if(usuarioService.getByEmail(loginUsuario.getEmail()).isPresent()) {
			Usuario usuario = usuarioService.getByEmail(loginUsuario.getEmail()).get();
			id = usuario.getId();
		}else if(restaurantService.getByEmail(loginUsuario.getEmail()).isPresent()){
			Restaurante usuario = restaurantService.getByEmail(loginUsuario.getEmail()).get();
			id = usuario.getNit();
		}
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities(),id);
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
    

}
