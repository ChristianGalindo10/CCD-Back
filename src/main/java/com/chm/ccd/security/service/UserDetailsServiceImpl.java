package com.chm.ccd.security.service;

import com.chm.ccd.model.Usuario;
import com.chm.ccd.service.ServicioRestaurante;
import com.chm.ccd.service.ServicioUsuario;
import com.chm.ccd.model.Restaurante;
import com.chm.ccd.model.SesionUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	ServicioUsuario usuarioService;

	@Autowired
	ServicioRestaurante restaurantService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		if (usuarioService.getByEmail(email).isPresent()) {
			Usuario usuario = usuarioService.getByEmail(email).get();
			return SesionUsuario.build(usuario);
		}else {
			if(restaurantService.getByEmail(email).isPresent()) {
				Restaurante restaurante = restaurantService.getByEmail(email).get();
				return SesionUsuario.build(restaurante);
			}else {
				Usuario usuario = usuarioService.getByEmail(email).get();
				return SesionUsuario.build(usuario);
			}
		}
	}

}
