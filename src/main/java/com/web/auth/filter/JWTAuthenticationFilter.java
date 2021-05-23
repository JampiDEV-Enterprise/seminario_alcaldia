package com.web.auth.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.auth.services.JWTService;
import com.web.auth.services.JWTServiceImpl;
import com.web.entities.Usuario;



public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private JWTService jwtService;
		
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		String email = obtainUsername(request);
		email = (email != null) ? email : "";
		email = email.trim();
		String password = obtainPassword(request);
		password = (password != null) ? password : "";
		
		logger.info("username desde request paramter: "+email);
		logger.info("password desde request paramter: "+password);
		
		if(email.equals("") || password.equals("")) {
			Usuario user=null;
			try {
				user=new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
				email=user.getEmail();
				password=user.getPassword();
				logger.info(user.getRol());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password);
		
		
		return this.authenticationManager.authenticate(authRequest);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String token = jwtService.create(authResult);
		
		response.addHeader(JWTServiceImpl.HEADER_STRING, JWTServiceImpl.TOKEN_PREFIX + token);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("token", token);
		body.put("user", (User) authResult.getPrincipal());
		body.put("mensaje", "Has Iniciado sesion correctamente");
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("application/json");
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException{

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("mensaje", "Error de autenticacion: username o password incorrecto!");
		body.put("error", failed.getMessage());
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(401);
		response.setContentType("application/json");
	}
	
}
