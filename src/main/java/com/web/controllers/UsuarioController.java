package com.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.Alcaldia;
import com.web.entities.Usuario;
import com.web.repository.services.AlcaldiaService;
import com.web.repository.services.UsuarioService;


@RestController
public class UsuarioController {
	
	  @Autowired
	  private UsuarioService usuarioService;
	  
	  @Autowired
	  private AlcaldiaService alcaldiaService;

	  @Autowired
	  private BCryptPasswordEncoder passwordEncoder;
	
	 @PostMapping("/signup/{idAlcaldia}")
	    public ResponseEntity<?> save(@PathVariable int idAlcaldia,@RequestBody Usuario user) {
		 try {
			 Alcaldia a = alcaldiaService.findById(idAlcaldia);
			Map<String, Object> map = new HashMap<String, Object>();
			 	if(a==null) {
			 	map.put("mensaje", "alcaldia inexistente!");
			 	return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			 	}
		        String bcryptPassword = passwordEncoder.encode(user.getPassword());
		        user.setPassword(bcryptPassword);
		        user.setAlcaldia(a);
		        usuarioService.save(user);
		        return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
		} catch (DataAccessException | InternalError e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mensaje", "hubo un error inesperado!");
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
