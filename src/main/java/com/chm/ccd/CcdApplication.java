package com.chm.ccd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CcdApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(CcdApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		/*String sql="INSERT INTO usuario (n_nombre,n_celular,n_tipo,p_contrasenia) VALUES ('jeiter2',123454,'cliente','1234')";
		int rows=jdbcTemplate.update(sql);
		if(rows>0) {
			System.out.println("exito")		;
		}*/
		System.out.println("exito");
	}
	
	@RestController
	class HelloWorld {
	    @GetMapping("/")
	    @CrossOrigin("*")
	    public ResponseEntity<?> hello() {
	        Map<String, String> data = new HashMap<>();
	        data.put("message", "Hello World");
	        return ResponseEntity.ok().body(data);
	    }

	}

}
