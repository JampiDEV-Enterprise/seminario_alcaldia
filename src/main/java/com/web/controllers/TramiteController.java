package com.web.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.web.entities.Tramite;
import com.web.entities.Usuario;
import com.web.repository.services.TramiteService;
import com.web.repository.services.UsuarioService;

@RestController
@RequestMapping("/tramite")
public class TramiteController {

	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private TramiteService tramiteService;
	
	@PostMapping("/save")
	public ResponseEntity<?> guardar(@RequestBody Tramite tramite,Principal principal){
		Usuario user=userService.findByEmail(principal.getName());
		
		Map<String,Object> map=new HashMap<>();
		
		try {
			tramite.setAlcaldia(user.getAlcaldia());
			map.put("tramite", this.tramiteService.save(tramite));
			map.put("mensaje","tramite creado correctamente");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.CREATED);
		}catch (DataAccessException e) {
			map.put("mensaje","El tramite no se ha podido crear correctamente!");
			map.put("error",e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		

	}

	@GetMapping("/listar")
	public List<Tramite> listar(Principal principal){
		Usuario user=this.userService.findByEmail(principal.getName());
		return this.tramiteService.listarPerteneciente(user.getAlcaldia().getIdAlcaldia());
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Tramite tramite) {
		Tramite tra=this.tramiteService.findByid(id);
		
		if(tra==null) {
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "El tramite a actulizar no se encontro en la base de datos");
			map.put("error", "El tramite en la bd no existe");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
		}
		
		
		try {
			
			tra.setTitulo(tramite.getTitulo());
			tra.setDescripcion(tramite.getDescripcion());
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "tramite actualizado corrctamente");
			map.put("tramite", this.tramiteService.save(tra));
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "El tramite no se pudo actualizar");
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
