package com.web.repository.services;

import java.util.List;

import com.web.entities.Alcaldia;

public interface AlcaldiaService {

	public Alcaldia guardar(Alcaldia entity);

	public Alcaldia findById(Integer id);
	
	public List<Alcaldia> listarEmpresas();

}
