package sysClub.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sysClub.entidades.Profesor;

public class ProfesorDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("puSysClub");

	public Profesor getProfesor(long dni) {
		EntityManager em = emf.createEntityManager();
		return em.find(Profesor.class, dni);
	}

	public void addProfesor(Profesor profe) {
		EntityManager em = emf.createEntityManager();
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
	
	public void deleteProfesor(Long dni)
	{
		EntityManager em = emf.createEntityManager();
		Profesor p = em.find(Profesor.class, dni);
		if (p!= null)
		{
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			
			try{
				em.remove(p);
				txn.commit();
			}catch(Exception ex)
			{
				if(txn.isActive())
					txn.rollback();
				ex.printStackTrace();
				throw ex;
			}
		}
		em.close();
		
	}
	
	
	

}
