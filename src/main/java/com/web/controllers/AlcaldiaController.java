package com.web.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.data.AlcaldiaApi;
import com.web.entities.Alcaldia;
import com.web.entities.SubCategoria;
import com.web.repository.services.AlcaldiaService;



@RestController
@RequestMapping("api/alcaldia")
public class AlcaldiaController {

	@Autowired
	private AlcaldiaService service;

	
	@PostMapping("")
	public ResponseEntity<Alcaldia> save(@RequestBody(required = false) AlcaldiaApi entrada) {

		Alcaldia alcaldia = service.findById(entrada.getIdAlcaldia());

		if (alcaldia == null) {
			try {
				Alcaldia alcalidaSave;

				

				alcaldia = new Alcaldia();
				alcaldia.setIdAlcaldia(entrada.getIdAlcaldia());
				alcaldia.setNombre(entrada.getNombre());
				alcaldia.setDireccion(entrada.getDireccion());
				alcaldia.setCorreo(entrada.getCorreo());
				alcaldia.setAlcalde(entrada.getAlcalde());
				alcaldia.setHorarioAtencion(entrada.getHorarioAtencion());
				alcaldia.setLogo(entrada.getLogo());
				alcaldia.setTelefono(entrada.getTelefono());
			

				

		

				alcalidaSave = service.guardar(alcaldia);
				return new ResponseEntity<>(alcalidaSave, HttpStatus.OK);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("mensaje", "hubo un error inesperado!");
				map.put("error", e.getCause().getMessage());
				return new ResponseEntity<Alcaldia>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Alcaldia>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("update")
	public ResponseEntity<Alcaldia> update(@RequestBody(required = false) AlcaldiaApi entrada) {


			Alcaldia alcaldia = service.findById(entrada.getIdAlcaldia());

			if (alcaldia != null) {

				
				Alcaldia alcaldiaEdit = new Alcaldia();

				
				alcaldia.setIdAlcaldia(entrada.getIdAlcaldia());
				alcaldia.setNombre(entrada.getNombre());
				alcaldia.setDireccion(entrada.getDireccion());
				alcaldia.setCorreo(entrada.getCorreo());
				alcaldia.setAlcalde(entrada.getAlcalde());
				alcaldia.setHorarioAtencion(entrada.getHorarioAtencion());
				alcaldia.setLogo(entrada.getLogo());
				alcaldia.setTelefono(entrada.getTelefono());
				

				try {
					alcaldiaEdit = service.guardar(alcaldiaEdit);
				} catch (Exception e) {
					return new ResponseEntity<Alcaldia>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<>(alcaldiaEdit, HttpStatus.OK);
			} else {
				return new ResponseEntity<Alcaldia>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} 

	}

	

	


