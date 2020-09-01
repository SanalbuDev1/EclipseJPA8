package ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.gm.sga.domain.Persona;

public class EncontrarPersona {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		// Crear persona
		tx.begin();
	
		Persona persona1 = em.find(Persona.class, 1l);

		log.debug("Persona buscada - estado detached " + persona1);
		
		em.close();
	}
}
