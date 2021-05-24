package com.web.repository.services;

import java.util.List;

import com.web.entities.Categoria;




public interface CategoriaService {

	public List<Categoria> listarCategorias();

	public Categoria save(Categoria entity);
	public Categoria findByCodigo(int idcategoria);

	


}
