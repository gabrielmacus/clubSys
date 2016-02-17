package sysClub.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sysClub.PersistenceManager;
import sysClub.entidades.Disciplina;

public class DisciplinaDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("puSysClub");
	
	public void addDisciplina(Disciplina d)
	{
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
	}
	
	public void deleteDisciplina(Long id)
	{
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		em.getTransaction().begin();
		Disciplina disc = em.find(Disciplina.class, id);
		if (disc!=null)
		{
			
			EntityTransaction txn= em.getTransaction();
			txn.begin();
			try{
				em.remove(disc);
				txn.commit();
			}catch(Exception ex)
			{
				ex.printStackTrace();
				if(txn.isActive() )
					txn.rollback();
				throw ex;
				
			}
					
		}
		em.close();
	}
	

}
