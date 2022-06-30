package com.chm.ccd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CcdApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CcdApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		String sql="INSERT INTO usuario (pk_identificador,n_nombre,n_celular,n_tipo,p_contrasenia) VALUES (12345,'jeiter',123454,'cliente','1234')";
		int rows=jdbcTemplate.update(sql);
		if(rows>0) {
			System.out.println("exito")		;
		}
	}

}
