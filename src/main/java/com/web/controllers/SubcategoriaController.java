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

import com.web.data.SubcategoriaApi;
import com.web.entities.Categoria;
import com.web.entities.SubCategoria;
import com.web.repository.services.CategoriaService;
import com.web.repository.services.SubcategoriaService;

@RestController
@RequestMapping("api/Categoria/Subcategoria")
public class SubcategoriaController {

	@Autowired
	private SubcategoriaService service;

	@Autowired
	private CategoriaService categoriaservice;

	@PostMapping("")
	public ResponseEntity<SubCategoria> save(@RequestBody(required = false) SubcategoriaApi entrada) {

		SubCategoria subcategoria = service.findById(entrada.getIdSubCategoria());

		if (subcategoria == null) {
			try {
				SubCategoria categoriasave;

				Categoria categoria = categoriaservice.findByCodigo(entrada.getCategoria());

				subcategoria = new SubCategoria();
				subcategoria.setIdSubCategoria(entrada.getIdSubCategoria());
				subcategoria.setDescripcion(entrada.getDescripcion());
				subcategoria.setOrden(entrada.getOrden());
				subcategoria.setTitulo(entrada.getTitulo());

				subcategoria.setCategoria(categoria);
				

				

				categoriasave = service.save(subcategoria);
				return new ResponseEntity<>(categoriasave, HttpStatus.OK);
			} catch (Exception e) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("mensaje", "hubo un error inesperado!");
				map.put("error", e.getCause().getMessage());
				return new ResponseEntity<SubCategoria>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<SubCategoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("update")
	public ResponseEntity<SubCategoria> update(@RequestBody(required = false) SubcategoriaApi entrada) {

		

			SubCategoria subcategoria = service.findById(entrada.getIdSubCategoria());

			if (subcategoria != null) {

				Categoria categoria = subcategoria.getCategoria();
				

				SubCategoria subcategoriaedit = new SubCategoria();

				
				subcategoriaedit.setIdSubCategoria(subcategoria.getIdSubCategoria());
				subcategoriaedit.setTitulo(entrada.getTitulo());
				subcategoriaedit.setDescripcion(entrada.getDescripcion());
				subcategoriaedit.setOrden(entrada.getOrden());
				

				try {
					subcategoriaedit = service.save(subcategoriaedit);
				} catch (Exception e) {
					return new ResponseEntity<SubCategoria>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<>(subcategoriaedit, HttpStatus.OK);
			} else {
				return new ResponseEntity<SubCategoria>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} 

	

	

	

}
