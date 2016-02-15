package sysClub.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Socio extends Persona {
	@Column(unique=true,nullable=false)
Integer nrosocio;
	
	@Temporal(TemporalType.DATE)
	Date fechaAsociacion;
	@Temporal(TemporalType.DATE)
	Date fechaBaja;
	public Socio(String nombre, String apellido, String direccion, String telefonos, Long dni, Integer nrosocio) {
		super(nombre, apellido, direccion, telefonos, dni);
		this.nrosocio = nrosocio;
		this.fechaAsociacion = new Date();
		
	}
	public Socio() {
		// TODO Auto-generated constructor stub
	}
	public Integer getNrosocio() {
		return nrosocio;
	}
	public void setNrosocio(Integer nrosocio) {
		this.nrosocio = nrosocio;
	}
	public Date getFechaAsociacion() {
		return fechaAsociacion;
	}
	public void setFechaAsociacion(Date fechaAsociacion) {
		this.fechaAsociacion = fechaAsociacion;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	
	
	
	
	
	
	
	
	
}
