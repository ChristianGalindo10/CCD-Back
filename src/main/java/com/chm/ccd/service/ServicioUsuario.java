package com.chm.ccd.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chm.ccd.db.RepositorioUsuario;
import com.chm.ccd.model.Usuario;

@Service
@Transactional
public class ServicioUsuario {

	@Autowired
    RepositorioUsuario usuarioRepository;
	
	public Optional<Usuario> getByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
	
	public Optional<Usuario> getById(Long id){
        return usuarioRepository.findById(id);
    }
	
	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
