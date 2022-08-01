package com.chm.ccd.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chm.ccd.db.RepositorioProducto;
import com.chm.ccd.model.Producto;
import com.chm.ccd.security.dto.Message;
import com.chm.ccd.service.ServicioProducto;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "productos")
public class ControladorProducto {
	
	@Autowired
	private RepositorioProducto repositorioProducto;
	
    @Autowired
    ServicioProducto productService;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
    private byte[] bytes;
	
	@GetMapping("/get")
	public List<Producto> getProductos() {
		return repositorioProducto.findAll();
	}
	@PostMapping("/upload")
	public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
		//this.bytes = compressBytes(file.getBytes());
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
        return new ResponseEntity(new Message("200"),HttpStatus.OK);
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
	@PostMapping("/newproduct")
	public ResponseEntity<?> nuevoProducto(@RequestParam Long nit,@RequestBody Producto nuevoProducto){
		System.out.println(nit);
		nuevoProducto.setPicByte(this.bytes);
		productService.save(nuevoProducto);
		this.bytes = null;
		return new ResponseEntity<Message>(new Message("Producto guardado"), HttpStatus.CREATED);
	}
}
