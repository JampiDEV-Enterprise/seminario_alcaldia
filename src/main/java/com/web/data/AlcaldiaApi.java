package com.web.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

import com.web.entities.EnlaceIntere;

import com.web.entities.Noticia;
import com.web.entities.PreguntaFrecuente;
import com.web.entities.Tramite;
import com.web.entities.Usuario;



public class AlcaldiaApi implements Serializable {
	private static final long serialVersionUID = 1L;

	
private int idAlcaldia;

private String alcalde;

private String correo;

private String direccion;

private String horarioAtencion;

private String logo;

private String nombre;

private String telefono;

private List<EnlaceIntere> enlaceInteres;


private List<Noticia> noticias;

private List<PreguntaFrecuente> preguntaFrecuentes;

private List<Tramite> tramites;

private List<Usuario> usuarios;

public int getIdAlcaldia() {
	return idAlcaldia;
}

public void setIdAlcaldia(int idAlcaldia) {
	this.idAlcaldia = idAlcaldia;
}

public String getAlcalde() {
	return alcalde;
}

public void setAlcalde(String alcalde) {
	this.alcalde = alcalde;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getHorarioAtencion() {
	return horarioAtencion;
}

public void setHorarioAtencion(String horarioAtencion) {
	this.horarioAtencion = horarioAtencion;
}

public String getLogo() {
	return logo;
}

public void setLogo(String logo) {
	this.logo = logo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public List<EnlaceIntere> getEnlaceInteres() {
	return enlaceInteres;
}

public void setEnlaceInteres(List<EnlaceIntere> enlaceInteres) {
	this.enlaceInteres = enlaceInteres;
}


public List<Noticia> getNoticias() {
	return noticias;
}

public void setNoticias(List<Noticia> noticias) {
	this.noticias = noticias;
}

public List<PreguntaFrecuente> getPreguntaFrecuentes() {
	return preguntaFrecuentes;
}

public void setPreguntaFrecuentes(List<PreguntaFrecuente> preguntaFrecuentes) {
	this.preguntaFrecuentes = preguntaFrecuentes;
}

public List<Tramite> getTramites() {
	return tramites;
}

public void setTramites(List<Tramite> tramites) {
	this.tramites = tramites;
}

public List<Usuario> getUsuarios() {
	return usuarios;
}

public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
}


	

	

}
