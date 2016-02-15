package sysClub.DAOs;

import java.util.List;

import javax.persistence.EntityManager;

import sysClub.PersistenceManager;
import sysClub.entidades.Persona;

public class PersonaDAO {
public void addPersona(Persona persona)
{
EntityManager em=	PersistenceManager.getInstance().getEntityManager();
em.getTransaction().begin();
em.persist(persona);
em.getTransaction().commit();
}
	
public void deletePersona(Long dni)
{
EntityManager em=	PersistenceManager.getInstance().getEntityManager();
em.getTransaction().begin();
Persona persona = em.find(Persona.class, dni);
em.remove(persona);
em.getTransaction().commit();
em.close();
}

public void updatePersona(Persona persona)
{

EntityManager em=	PersistenceManager.getInstance().getEntityManager();

Persona p = em.find(Persona.class, persona.getDni());
em.getTransaction().begin();
p.setApellido(persona.getApellido());
p.setDireccion(persona.getDireccion());
p.setNombre(persona.getNombre());
p.setTelefonos(persona.getTelefonos());
em.persist(p);
em.getTransaction().commit();
em.close();

}

public List<Persona> getPersonas()
{EntityManager em =PersistenceManager.getInstance().getEntityManager();
	List<Persona> personas =	em.createQuery("select p from Persona p", Persona.class).getResultList();;
	em.close();
	return personas; 
	
}

}
