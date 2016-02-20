package sysClub.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Disciplina {

	@Id
	@GeneratedValue
	Long id_disciplina;
	@ManyToOne(fetch=FetchType.LAZY)
	Profesor profesor;
	@Column(nullable=false,length=30)
String nombre;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
Date horaInicio;
	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
Date  horaFin;
	@Column(nullable=false)
@Temporal(TemporalType.DATE)
Date fechaInicio;
	@Column(nullable=false)
@Temporal(TemporalType.DATE)
Date fechaFinal;
	@ManyToMany
	List<Socio>listaSocios =new ArrayList<>();
@Column(columnDefinition="numeric(10,2)",nullable=false)
Double importe;
@Column(nullable=false)
Float porcentajeAlProfesor;
public Disciplina()
{
	
}

public Disciplina(String nombre,Date horaInicio, Date horaFin, Date fechaInicio, Date fechaFinal, Double importe,
		Float porcentajeAlProfesor) {
	super();
	this.nombre = nombre;
	this.horaInicio = horaInicio;
	this.horaFin = horaFin;
	this.fechaInicio = fechaInicio;
	this.fechaFinal = fechaFinal;
	this.importe = importe;
	this.porcentajeAlProfesor = porcentajeAlProfesor;
}

public List<Socio> getListaSocios() {
	return listaSocios;
}

public void setListaSocios(List<Socio> listaSocios) {
	this.listaSocios = listaSocios;
}

public Profesor getProfesor() {
	return profesor;
}

public void setProfesor(Profesor profesor) {
	this.profesor = profesor;
}

public Long getId_disciplina() {
	return id_disciplina;
}

public void setId_disciplina(Long id_disciplina) {
	this.id_disciplina = id_disciplina;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Date getHoraInicio() {
	return horaInicio;
}

public void setHoraInicio(Date horaInicio) {
	this.horaInicio = horaInicio;
}

public Date getHoraFin() {
	return horaFin;
}

public void setHoraFin(Date horaFin) {
	this.horaFin = horaFin;
}

public Date getFechaInicio() {
	return fechaInicio;
}

public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
}

public Date getFechaFinal() {
	return fechaFinal;
}

public void setFechaFinal(Date fechaFinal) {
	this.fechaFinal = fechaFinal;
}

public Double getImporte() {
	return importe;
}

public void setImporte(Double importe) {
	this.importe = importe;
}

public Float getPorcentajeAlProfesor() {
	return porcentajeAlProfesor;
}

public void setPorcentajeAlProfesor(Float porcentajeAlProfesor) {
	this.porcentajeAlProfesor = porcentajeAlProfesor;
}



}
