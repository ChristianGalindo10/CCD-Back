package com.chm.ccd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chm.ccd.security.jwt.JwtEntryPoint;
import com.chm.ccd.security.jwt.JwtTokenFilter;
import com.chm.ccd.security.service.UserDetailsServiceImpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity{
	
	@Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtEntryPoint jwtEntryPoint;
	
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration authConfig,HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        // Get AuthenticationManager
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
		//return authConfig.getAuthenticationManager();
        return authenticationManager;
	}
	
	
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		/*http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/users/**", "/settings/**")
				.hasAuthority("Admin").hasAnyAuthority("Admin", "Editor", "Salesperson")
				.hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper").anyRequest().authenticated().and()
				.formLogin().loginPage("/login").usernameParameter("email").permitAll().and().rememberMe()
				.key("AbcdEfghIjklmNopQrsTuvXyz_0123456789").and().logout().permitAll();

		http.headers().frameOptions().sameOrigin();*/
        

		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/auth/**","/productos/get","/menus/get","/restaurantes/get","/ingredientes/get")
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
	}
}
