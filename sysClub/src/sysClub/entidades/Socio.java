package sysClub.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	@ManyToOne(fetch=FetchType.LAZY)
	Categoria categoria;
	@ManyToMany(mappedBy="listaSocios")
	List<Disciplina>listaDisciplinas=new ArrayList<>();
	
	public Socio(String nombre, String apellido, String direccion, String telefonos, Long dni, Integer nrosocio,Categoria categoria) {
		super(nombre, apellido, direccion, telefonos, dni);
		this.nrosocio = nrosocio;
		this.fechaAsociacion = new Date();
		this.categoria=categoria;
		
	}
	public Socio() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}
	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
	
	
	
	
	
}
