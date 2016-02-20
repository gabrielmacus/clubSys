package sysClub.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Socio extends Persona {
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)	
int nrosocio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaAsociacion;
	@Temporal(TemporalType.DATE)
	private Date fechaBaja;
	@ManyToOne
	private Categoria categoria;
	@ManyToMany(mappedBy="listaSocios")
	private List<Disciplina>listaDisciplinas=new ArrayList<>();
	@OneToMany(cascade= CascadeType.REMOVE,mappedBy="socio")
	private List<Cuota>cuotas=new ArrayList<>();
	public Socio(String nombre, String apellido, String direccion, String telefonos, Long dni, Categoria categoria) {
		super(nombre, apellido, direccion, telefonos, dni);
	
		this.fechaAsociacion = new Date();
		this.categoria=categoria;
		
	}
	public Socio() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Cuota> getCuotas() {
		return cuotas;
	}
	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
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
