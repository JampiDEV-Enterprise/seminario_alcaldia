package com.web.data;

import java.io.Serializable;
import java.util.Date;




public class CategoriaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idCategoria;

	private String descripcion;

	private String orden;

	private String titulo;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

	

	

}
