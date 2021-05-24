package com.web.repository.dao;



import org.springframework.data.repository.CrudRepository;

import com.web.entities.SubCategoria;




public interface ISubcategoriaDao extends CrudRepository<SubCategoria, Integer> {

	public SubCategoria findById(int idsubcategoria);

}
