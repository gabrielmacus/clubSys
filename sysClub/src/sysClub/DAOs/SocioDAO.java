package sysClub.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sysClub.PersistenceManager;
import sysClub.entidades.Socio;

public class SocioDAO {
	
	public List<Socio> getListaSocio()
	{
		EntityManager em =PersistenceManager.getInstance().getEntityManager();
		TypedQuery<Socio> q = em.createQuery("select s from Socio s", Socio.class);
		List<Socio> s = q.getResultList();
		em.close();
		return s;
	}
	
	public Socio returnSocio(Long dni)
	{
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		return em.find(Socio.class, dni);
	}
	
	public void addSocio(Socio socio) {
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		if (socio != null) {
			try {
				em.persist(socio);
				em.getTransaction().commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				if (txn.isActive())
					txn.rollback();
				throw ex;

			}

		}
		em.close();
	}

	public void deleteSocio(Long dni) {
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		EntityTransaction txn = em.getTransaction();

		txn.begin();
		Socio socio = em.find(Socio.class, dni);
		if (socio != null) {
			try {
				em.remove(socio);
				em.getTransaction().commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				if (txn.isActive())
					txn.rollback();
				throw ex;
			}
		}
		em.close();
	}

	public void updateSocio(Socio socio) {
		EntityManager em = PersistenceManager.getInstance().getEntityManager();

		Socio s = em.find(Socio.class, socio.getDni());
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		if (s != null) {
			
				s.setApellido(socio.getApellido());
				s.setDireccion(socio.getDireccion());
				s.setNombre(socio.getNombre());
				s.setTelefonos(socio.getTelefonos());
				s.setNrosocio(socio.getNrosocio());
				s.setFechaAsociacion(socio.getFechaAsociacion());
				s.setFechaBaja(socio.getFechaBaja());
				s.setCategoria(socio.getCategoria());
				try {
				em.persist(s);
				em.getTransaction().commit();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				if (txn.isActive())
					txn.rollback();
				throw ex;
			}
			em.close();
		}
	}
}
