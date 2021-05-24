package com.web.repository.services;

import java.util.List;

import com.web.entities.Noticia;

public interface NoticiaService {

	public List<Noticia> findAll();
	public Noticia save(Noticia noticia);
	public Noticia findById(int id);
	public String remove(int id);
}
