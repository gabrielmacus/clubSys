package sysClub;


import java.util.Date;

import javax.persistence.EntityManager;

import sysClub.DAOs.PersonaDAO;
import sysClub.DAOs.SocioDAO;
import sysClub.entidades.Categoria;
import sysClub.entidades.Disciplina;
import sysClub.entidades.Persona;
import sysClub.entidades.Profesor;
import sysClub.entidades.Socio;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	
	PersonaDAO personaDAO =new PersonaDAO();

Persona persona=new Persona("Alberto", "Rodriguez", "Cochabamba 123", "4333244,4323422", 20303033l);
	personaDAO.addPersona(persona);
	persona.setApellido("Ramirez");
	personaDAO.updatePersona(persona);
	
	Categoria cat = new Categoria("Premium", "acceso total", new Double(1150));

	Categoria cat2 = new Categoria("Bajo", "acceso restringido", new Double(1150));
EntityManager em=	PersistenceManager.getInstance().getEntityManager();
Profesor profesor= new Profesor("Alberto", "Rodriguez", "Cochabamba 123", "4333244,4323422", 20303038l,"Profesor de Educacion Fisica");
em.getTransaction().begin();
em.persist(cat);
em.persist(cat2);
em.persist(profesor);
em.getTransaction().commit();
	
	SocioDAO socioDAO = new SocioDAO();
    Socio socio = new Socio("Juan", "Ibañez", "Albania 234", "433434", 32323233l, 1011,cat);
    
    socioDAO.addSocio(socio);
    
    socio.setApellido("Cabrera");
    socio.setCategoria(cat2);
    
  socio.setFechaBaja(new Date());
	socioDAO.updateSocio(socio);

	
	
	Disciplina disciplina =new Disciplina("Futbol", (byte)17, (byte)19,new Date(),new Date(),new Double(223),23f);
	disciplina.setProfesor(profesor);
	
	em.getTransaction().begin();
	em.persist(disciplina);

em.persist(cat2);
	

em.getTransaction().commit();
	
	
	
	}
	

}
