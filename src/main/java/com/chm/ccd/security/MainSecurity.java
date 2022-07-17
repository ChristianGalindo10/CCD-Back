package com.chm.ccd.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		/*http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/users/**", "/settings/**")
				.hasAuthority("Admin").hasAnyAuthority("Admin", "Editor", "Salesperson")
				.hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper").anyRequest().authenticated().and()
				.formLogin().loginPage("/login").usernameParameter("email").permitAll().and().rememberMe()
				.key("AbcdEfghIjklmNopQrsTuvXyz_0123456789").and().logout().permitAll();

		http.headers().frameOptions().sameOrigin();*/

		

		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling();
				/*.authenticationEntryPoint(jwtEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);*/
		
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
	}
}
