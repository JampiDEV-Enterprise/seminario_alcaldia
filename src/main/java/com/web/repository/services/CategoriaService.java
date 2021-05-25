package com.web.repository.services;

import java.util.List;

import com.web.entities.Categoria;




public interface CategoriaService {

	public List<Categoria> findAll();

	public Categoria save(Categoria entity);
	
	public Categoria findById(int idcategoria);
	
	public String remove(int id);

	


}
