package com.web.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the foto database table.
 * 
 */
@Entity
@Table(name="foto")
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_foto")
	private int idFoto;

	private String descripcion;

	private String titulo;

	//bi-directional many-to-one association to Galeria
	@ManyToOne
	@JoinColumn(name="galeria_id")
	private Galeria galeria;

	public Foto() {
	}

	public int getIdFoto() {
		return this.idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Galeria getGaleria() {
		return this.galeria;
	}

	public void setGaleria(Galeria galeria) {
		this.galeria = galeria;
	}

}