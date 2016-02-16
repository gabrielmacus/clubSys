package sysClub.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Profesor extends Persona {
    @Column(length =30,nullable=false)
	String titulo;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="profesor")
   List<Disciplina>disciplinasAsociadas=new ArrayList<>();




public Profesor(String nombre, String apellido, String direccion, String telefonos, Long dni, String titulo) {
	super(nombre, apellido, direccion, telefonos, dni);
	this.titulo = titulo;
}


public Profesor()
{
	
}
public List<Disciplina> getDisciplinasAsociadas() {
	return disciplinasAsociadas;
}
public void setDisciplinasAsociadas(List<Disciplina> disciplinasAsociadas) {
	this.disciplinasAsociadas = disciplinasAsociadas;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}

}
