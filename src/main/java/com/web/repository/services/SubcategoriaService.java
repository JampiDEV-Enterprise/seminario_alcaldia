package com.web.repository.services;

import java.util.List;

import com.web.entities.SubCategoria;






public interface SubcategoriaService {

	public List<SubCategoria> listarSubcategorias();

	public SubCategoria save(SubCategoria entity);
	public SubCategoria findById(int idsubcategoria);

	


}
