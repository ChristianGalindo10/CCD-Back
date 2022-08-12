package com.chm.ccd.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chm.ccd.db.RepositorioMenu;
import com.chm.ccd.model.Ingrediente;
import com.chm.ccd.model.Menu;
import com.chm.ccd.model.Producto;
import com.chm.ccd.model.Producto_Ingrediente;
import com.chm.ccd.model.Restaurante_Producto;
import com.chm.ccd.security.dto.Message;
import com.chm.ccd.service.ServicioRestaurante;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "menus")
public class ControladorMenu {

	@Autowired
	private RepositorioMenu repositorioMenu;
	
	@Autowired
	private ServicioRestaurante servicioRestaurante;
	
	@GetMapping("/get")
	public List<Menu> getMenus() {
		return repositorioMenu.findAll();
	}
	
	private byte[] bytes;
	
	@PostMapping("/upload")
	public ResponseEntity<Message> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = null;
		this.bytes = file.getBytes();
		//this.bytes = compressBytes(file.getBytes());
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
        return new ResponseEntity<Message>(new Message("200"),HttpStatus.OK);
	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	
	@Transactional
	@PostMapping("/newmenu")
	public ResponseEntity<?> nuevoMenu(@RequestBody Menu menu){
		Long nit = menu.getNit();
		menu.setRestaurante(servicioRestaurante.getByNit(nit));
		menu.setPicByte(this.bytes);
		repositorioMenu.save(menu);
		this.bytes = null;
		return new ResponseEntity<Message>(new Message("Menú guardado"), HttpStatus.CREATED);
	}
}
