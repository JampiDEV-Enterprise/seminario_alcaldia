package com.web.repository.services;

import java.util.List;

import com.web.entities.Tramite;

public interface TramiteService {

	public Tramite findByid(int id);
	public List<Tramite> listarPerteneciente(int user);
	public Tramite save(Tramite tramite);
	public void deleteById(int id);
	
}
