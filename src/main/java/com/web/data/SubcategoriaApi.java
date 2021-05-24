package com.web.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.web.entities.Categoria;
import com.web.entities.Noticia;




public class SubcategoriaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idSubCategoria;

	private String descripcion;

	private int orden;

	private String titulo;
	
	public int getIdSubCategoria() {
		return idSubCategoria;
	}

	public void setIdSubCategoria(int idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	private int categoria;
	
	

	

	

}
