package ClientesAsociados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;

public class PersistenciaCascadaJPA {
	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Usuario user = new Usuario();
		user.setUsername("Santy");
		user.setPassword("1234");
		user.setIdPersona(new Persona("Lola", "Lola", "Lola3", "Lola"));
		
		em.persist(user);
		
		log.debug("Usuario deteached " + user);
		
		tx.commit();
		
		log.debug("Usuario agregado " + user);
		
	}
}
