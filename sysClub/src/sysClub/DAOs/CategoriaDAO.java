package sysClub.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import sysClub.entidades.Categoria;

public class CategoriaDAO {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("puSysClub");

	public void AddCategoria(Categoria categoria) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		if (categoria != null) {
			try {
				em.persist(categoria);
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

	public List<Categoria> getListaCat() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Categoria> q = em.createQuery("select c from Categoria c", Categoria.class);
		List<Categoria> cat = q.getResultList();
		em.close();
		return cat;

	}

	public Categoria getCategoria(Long id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Categoria.class, id);

	}

	public void deleteCategoria(Long id) {
		EntityManager em = emf.createEntityManager();
		Categoria c = em.find(Categoria.class, id);
		if (c != null) {
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			try {
				em.remove(c);
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

	public void updateCategoria(Categoria cat) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Categoria c = em.find(Categoria.class, cat.getId_categoria());
		if(c!=null)
		{
			c.setDescripcion(cat.getDescripcion());
			c.setImporteMensual(cat.getImporteMensual());
			c.setListaSocios(cat.getListaSocios());
			c.setNombre(cat.getNombre());
			try{
				txn.begin();
				em.merge(c);
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
