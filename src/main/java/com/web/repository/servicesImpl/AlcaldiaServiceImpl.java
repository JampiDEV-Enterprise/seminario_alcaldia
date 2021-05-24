package com.web.repository.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Alcaldia;
import com.web.repository.dao.IAlcaldiaDao;
import com.web.repository.services.AlcaldiaService;

@Service
public class AlcaldiaServiceImpl implements AlcaldiaService {

	Logger logger = LoggerFactory.getLogger(AlcaldiaServiceImpl.class);

	@Autowired
	private IAlcaldiaDao repository;

	@Override
	public Alcaldia guardar(Alcaldia entity) {
		try {
			
			return repository.save(entity);
		} catch (Exception e) {
			logger.error("Registrar alcaldia", e);
		}
		return null;
	}

	@Override
	public Alcaldia findById(Integer id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			logger.error("Busqueda alcaldia por id", e);
		}
		return null;
	}

	@Override
	public List<Alcaldia> listarEmpresas() {
		try {
			return (List<Alcaldia>) repository.findAll();
		} catch (Exception e) {
			logger.error("Listar alcaldia", e);
		}
		return new ArrayList<>();
	}

}
