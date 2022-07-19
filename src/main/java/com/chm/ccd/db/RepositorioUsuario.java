package com.chm.ccd.db;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	boolean existsByEmail(String email);
}
