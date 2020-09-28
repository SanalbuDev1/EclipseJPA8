package interfaces;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Sedes;

@Stateless
public class SedesImpl implements SedesI {

	@PersistenceContext(unitName = "SgaPu")
	EntityManager em;
	
	@Override
	public List<Sedes> findAll() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Sedes.findAll").getResultList();
	}

}
