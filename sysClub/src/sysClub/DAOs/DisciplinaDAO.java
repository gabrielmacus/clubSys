package sysClub.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sysClub.PersistenceManager;
import sysClub.entidades.Disciplina;

public class DisciplinaDAO {
	
	public void addDisciplina(Disciplina d)
	{
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
	}
	public List<Disciplina>getDisciplinas()
	{
		EntityManager em = PersistenceManager.getInstance().getEntityManager();
		List<Disciplina> disciplinas = em.createQuery("select d from Disciplina d", Disciplina.class).getResultList();
		em.close();
		return disciplinas;
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
	
	
	public void updateDisciplina(Disciplina d){
	
		EntityManager em=PersistenceManager.getInstance().getEntityManager();
		Disciplina disc=em.find(Disciplina.class, d.getId_disciplina());
		
		if (disc!=null)
		{
			disc.setNombre(d.getNombre());
			disc.setHoraInicio(d.getHoraInicio());
			disc.setHoraFin(d.getHoraFin());
			disc.setFechaInicio(d.getFechaInicio());
			disc.setFechaFinal(d.getFechaFinal());
			disc.setImporte(d.getImporte());
			disc.setPorcentajeAlProfesor(d.getPorcentajeAlProfesor());
			EntityTransaction txn= em.getTransaction();
			txn.begin();
			try{
				em.merge(disc);
				txn.commit();
				
			}catch (Exception ex) {
				ex.printStackTrace();
				if (txn.isActive())
					txn.rollback();
				throw ex;
			}
		}
		em.close();
			
		
		
	}
	
	

}
