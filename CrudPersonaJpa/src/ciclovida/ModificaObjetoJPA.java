package ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.gm.sga.domain.Persona;

public class ModificaObjetoJPA {

	static Logger log = LogManager.getRootLogger();
		
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Persona persona1 = em.find(Persona.class,1l);		
		
		tx.commit();
		
		//objeto en estado detache
		log.debug("Objeto recuperado " + persona1);
		
		persona1.setNombre("Modificado");
		persona1.setApellido("Modificado");		
		
		tx.begin(); 			
		em.merge(persona1);
		em.flush();
		
		tx.commit();
		
		log.debug("Modificar - estado detached " + persona1);
	}
	
	
	
}
