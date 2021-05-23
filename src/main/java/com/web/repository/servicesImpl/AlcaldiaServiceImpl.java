package com.web.repository.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Alcaldia;
import com.web.repository.dao.IAlcaldiaDao;
import com.web.repository.services.AlcaldiaService;

@Service
public class AlcaldiaServiceImpl implements AlcaldiaService {

	@Autowired
	IAlcaldiaDao alcaldiaDao;
	
	@Override
	public Alcaldia findById(int id) {
		return alcaldiaDao.findById(id).orElse(null);
	}

}
