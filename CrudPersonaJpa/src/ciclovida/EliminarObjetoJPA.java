package ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.gm.sga.domain.Persona;

public class EliminarObjetoJPA {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Persona persona1 = new Persona("Eliminar","Eliminar","Eliminar","Eliminar");
		em.persist(persona1);
		log.debug("Objeto recuperado " + persona1);

	
		
		em.remove(em.merge(persona1));
		tx.commit();

		// objeto en estado detache
		log.debug("Objeto borrado " + persona1);

	}
}
