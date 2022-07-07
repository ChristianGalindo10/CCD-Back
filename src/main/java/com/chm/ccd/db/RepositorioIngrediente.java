package com.chm.ccd.db;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chm.ccd.model.Ingrediente;

public interface RepositorioIngrediente extends JpaRepository<Ingrediente, Integer> {

}
