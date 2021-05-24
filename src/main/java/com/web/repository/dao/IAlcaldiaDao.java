package com.web.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.Alcaldia;





public interface IAlcaldiaDao extends CrudRepository<Alcaldia, Integer>{

	public Alcaldia buscarPorIdentificador(Integer id);
}
