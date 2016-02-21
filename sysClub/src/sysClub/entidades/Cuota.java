package sysClub.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cuota {
	@Id
	@GeneratedValue
	private Long id_cuota;
@ManyToOne
private Socio socio;
	@Temporal(TemporalType.DATE)
private Date fecha;
	@Column(columnDefinition="numeric(10,2)")
private	Long montoTotal;
	public Cuota(Long id_cuota,Date fecha, Long montoTotal) {
		super();
		this.id_cuota = id_cuota;
		this.fecha =fecha;
		this.montoTotal = montoTotal;
	}

	public Cuota()
	{
		
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Long getId_cuota() {
		return id_cuota;
	}

	public void setId_cuota(Long id_cuota) {
		this.id_cuota = id_cuota;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Long montoTotal) {
		this.montoTotal = montoTotal;
	}


	
}
