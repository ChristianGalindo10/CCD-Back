package com.chm.ccd.db;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByName(String name);
	Optional<Usuario> findByEmail(String email);
	boolean existsByEmail(String email);
}
