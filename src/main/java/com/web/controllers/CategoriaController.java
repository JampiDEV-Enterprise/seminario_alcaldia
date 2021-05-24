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

import com.web.data.CategoriaApi;
import com.web.entities.Categoria;
import com.web.repository.services.CategoriaService;



@RestController
@RequestMapping("api/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@PostMapping("")
	public ResponseEntity<Categoria> save(@RequestBody(required = false) CategoriaApi entrada) {

		Categoria categoria = service.findByCodigo(entrada.getIdCategoria());

		if (categoria == null) {
			try {
				Categoria categoriasave;

				categoria = new Categoria();
				categoria.setIdCategoria(entrada.getIdCategoria());
				categoria.setDescripcion(entrada.getDescripcion());
				categoria.setOrden(entrada.getOrden());
				categoria.setTitulo(entrada.getTitulo());
				

				

				categoriasave = service.save(categoria);
				return new ResponseEntity<>(categoriasave, HttpStatus.OK);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("mensaje", "hubo un error inesperado!");
				map.put("error", e.getCause().getMessage());
				return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("update")
	public ResponseEntity<Categoria> update(@RequestBody(required = false) CategoriaApi entrada) {

		

			Categoria categoria = service.findByCodigo(entrada.getIdCategoria());

			if (categoria != null) {

				Categoria categoriaedit = new Categoria();

				
				categoriaedit.setIdCategoria(categoria.getIdCategoria());
				categoriaedit.setOrden(entrada.getOrden());
				categoriaedit.setDescripcion(entrada.getDescripcion());
				categoriaedit.setTitulo(entrada.getTitulo());
				

				try {
					categoriaedit = service.save(categoriaedit);
				} catch (Exception e) {
					return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<>(categoriaedit, HttpStatus.OK);
			} else {
				
						return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

	

	

}
}
