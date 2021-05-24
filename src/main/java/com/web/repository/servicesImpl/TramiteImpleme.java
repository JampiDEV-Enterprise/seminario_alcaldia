package com.web.repository.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Tramite;
import com.web.repository.dao.ITramiteDao;
import com.web.repository.services.TramiteService;

@Service
public class TramiteImpleme implements TramiteService {

	
	@Autowired
	private ITramiteDao tramite;
	
	@Override
	public Tramite findByid(int id) {
	 return this.tramite.findById(id).orElse(null);
	}

	@Override
	public List<Tramite> listarPerteneciente(int user) {
		// TODO Auto-generated method stub
		return this.tramite.listar(user);
	}

	@Override
	public Tramite save(Tramite tramite) {
		// TODO Auto-generated method stub
		return this.tramite.save(tramite);
	}

	@Override
	public void deleteById(int id) {
		this.tramite.deleteById(id);
	}

}
