package sysClub.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	@Id
	@GeneratedValue
	Long id_categoria;
@Column(length=30,nullable=false)
String nombre;
@Lob
@Column(nullable=false)
String descripcion;

@Column(columnDefinition="numeric(10,2)",nullable=false)
Double importeMensual;
@OneToMany(mappedBy="categoria")
List<Socio>listaSocios=new ArrayList<>();


public Categoria()
{
	
}



public Categoria(String nombre, String descripcion, Double importeMensual) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.importeMensual = importeMensual;
}
public Long getId_categoria() {
	return id_categoria;
}
public void setId_categoria(Long id_categoria) {
	this.id_categoria = id_categoria;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Double getImporteMensual() {
	return importeMensual;
}
public void setImporteMensual(Double importeMensual) {
	this.importeMensual = importeMensual;
}
public List<Socio> getListaSocios() {
	return listaSocios;
}
public void setListaSocios(List<Socio> listaSocios) {
	this.listaSocios = listaSocios;
}


}
