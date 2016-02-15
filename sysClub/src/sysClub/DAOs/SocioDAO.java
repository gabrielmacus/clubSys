package sysClub.DAOs;

import javax.persistence.EntityManager;

import sysClub.PersistenceManager;
import sysClub.entidades.Socio;

public class SocioDAO {

	public void addSocio(Socio socio)
	{
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(socio);
		em.getTransaction().commit();
		
	}
	public void deleteSocio(Long dni)
	{
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		em.getTransaction().begin();
		Socio socio = em.find(Socio.class, dni);
		em.remove(socio);
		em.getTransaction().commit();
		
	}
	public void updateSocio(Socio socio)
	{EntityManager em=	PersistenceManager.getInstance().getEntityManager();

Socio s = em.find(Socio.class,socio.getDni());
em.getTransaction().begin();
s.setApellido(socio.getApellido());
s.setDireccion(socio.getDireccion());
s.setNombre(socio.getNombre());
s.setTelefonos(socio.getTelefonos());
s.setNrosocio(socio.getNrosocio());
s.setFechaAsociacion(socio.getFechaAsociacion());
s.setFechaBaja(socio.getFechaBaja());
em.persist(s);
em.getTransaction().commit();
em.close();
		
	}
}
