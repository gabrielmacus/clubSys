package sysClub.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sysClub.PersistenceManager;
import sysClub.entidades.Profesor;

public class ProfesorDAO {

	public Profesor getProfesor(long dni) {
		EntityManager em =PersistenceManager.getInstance().getEntityManager();
		return em.find(Profesor.class, dni);
	}

	public void addProfesor(Profesor profe) {
		EntityManager em =PersistenceManager.getInstance().getEntityManager();
		Profesor p = em.find(Profesor.class, profe.getDni());

		if (p != null) {
			p.setApellido(profe.getApellido());
			p.setDireccion(profe.getDireccion());
			p.setDisciplinasAsociadas(profe.getDisciplinasAsociadas());
			p.setNombre(profe.getNombre());
			p.setTelefonos(profe.getTelefonos());
			p.setTitulo(profe.getTitulo());
			EntityTransaction txn = em.getTransaction();
			txn.begin();

			try {
				em.merge(p);
				txn.commit();
			} catch (Exception ex) {
				if (txn.isActive())
					txn.rollback();
				ex.printStackTrace();
				throw ex;
			}

		}
		em.close();
	}

	public void deleteProfesor(Long dni) {
		EntityManager em =PersistenceManager.getInstance().getEntityManager();
		Profesor p = em.find(Profesor.class, dni);
		if (p != null) {
			EntityTransaction txn = em.getTransaction();
			txn.begin();

			try {
				em.remove(p);
				txn.commit();
			} catch (Exception ex) {
				if (txn.isActive())
					txn.rollback();
				ex.printStackTrace();
				throw ex;
			}
		}
		em.close();

	}

	public void updateProfesor(Profesor profe) {
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		Profesor p = em.find(Profesor.class, profe.getDni());
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		if (p != null) {
			p.setApellido(profe.getApellido());
			p.setDireccion(profe.getDireccion());
			p.setDisciplinasAsociadas(profe.getDisciplinasAsociadas());
			p.setNombre(profe.getNombre());
			p.setTelefonos(profe.getTelefonos());
			p.setTitulo(profe.getTitulo());
			try {
				em.merge(p);
				txn.commit();
			} catch (Exception ex) {
				if (txn.isActive())
					txn.rollback();
				ex.printStackTrace();
				throw ex;
			}
		}
		em.close();
	}

}
