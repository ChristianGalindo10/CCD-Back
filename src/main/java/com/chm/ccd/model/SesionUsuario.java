package com.chm.ccd.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SesionUsuario implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String name;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    
    public SesionUsuario(String nombre,  String password, String email ,Collection<? extends GrantedAuthority> authorities) {
    	this.name = nombre;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }
    
    public static SesionUsuario build(Usuario usuario){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getTipo());
        authorities.add(authority);
        return new SesionUsuario(usuario.getName(), usuario.getPassword(), usuario.getEmail(), authorities);
    }
    
    public static SesionUsuario build(Restaurante restaurante){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("restaurante");
        authorities.add(authority);
        return new SesionUsuario(restaurante.getNombre(), restaurante.getPassword(), restaurante.getEmail(), authorities);
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	

}
