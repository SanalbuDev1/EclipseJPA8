package clientes.jpql;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;

public class PruebaJPQL {
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		String jpql = null;
		Query q = null;
		List<Persona> personas = null;
		Persona persona = null;
		Iterator iter = null;
		Object[] tupla = null;
		List<Usuario> usuario = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		// 1. Consultar todos los objetos persona
		tx.begin();

		log.debug("Consultando todas las personas " + persona);
		jpql = "select p from Persona p";
		personas = em.createQuery(jpql).getResultList();

		// Consulta1
		mostrarPersonas(personas);

		// 2. Consultar persona con llave primaria
		log.debug("\n2 Consultando persona por llave primaria = 1");
		jpql = "select p from Persona p where p.idPersona = 1";
		persona = (Persona) em.createQuery(jpql).getSingleResult();
		mostrarPersonas(persona);

		// 3. Consultar persona por nombre
		log.debug("\n2 Consultando persona por nombre = 'lola'");
		jpql = "select p from Persona p where p.nombre = 'lola'";
		personas = em.createQuery(jpql).getResultList();
		mostrarPersonas(personas);

		// 4. Consultar datos individuales - tupla
		log.debug("\n2 Consultando datos individuales'");
		jpql = "select p.nombre as nombre, p.apellido as apellido, p.email as email, p.idPersona as id from Persona p";
		iter = em.createQuery(jpql).getResultList().iterator();
		while (iter.hasNext()) {
			tupla = (Object[]) iter.next();
			String nombre = (String) tupla[0];
			String apellido = (String) tupla[1];
			String email = (String) tupla[2];
			Long id = (Long) tupla[3];

			log.debug("id " + id + " Iterator " + nombre + " " + apellido + " " + email);
		}

		// 5. Obtiene el objeto persona y el id, se crea un arreglo de tipo object con 2
		// columnas
		log.debug("\n2 Obtiene el objeto persona y el id, se crea un arreglo de tipo object con 2 columnas'");
		jpql = "select p, p.idPersona from Persona p";
		iter = em.createQuery(jpql).getResultList().iterator();
		while (iter.hasNext()) {
			tupla = (Object[]) iter.next();
			Persona p = (Persona) tupla[0];
			Long id = (Long) tupla[1];

			log.debug("id " + id + " Persona " + persona);
		}

		// 6. Consulta de todas las personas con constructo de la clase
		log.debug("\n2 Consulta de todas las personas'");
		jpql = "select new mx.com.gm.sga.domain.Persona(p.idPersona , p.email) from Persona p";
		personas = em.createQuery(jpql).getResultList();
		mostrarPersonas(personas);

		// 7. Consulta valor minimo y maximo del id persona
		log.debug("\n2 Consulta valor minimo y maximo del id persona");
		jpql = "select min(p.idPersona) as minimo, max(p.idPersona) as maximo, count(p.idPersona) as Contador from Persona p";
		iter = em.createQuery(jpql).getResultList().iterator();
		while (iter.hasNext()) {
			tupla = (Object[]) iter.next();
			Long minimo = (Long) tupla[0];
			Long maximo = (Long) tupla[1];
			Long contador = (Long) tupla[2];

			log.debug("Minimo " + minimo + " Maximo " + maximo + " CONTADOR " + contador);
		}

		// 8. Contador de nombres distintos
		log.debug("\n2 Contador de nombres distintos");
		jpql = "select count(distinct p.nombre) as Contador from Persona p";
		Long contador = (Long) em.createQuery(jpql).getSingleResult();
		System.out.println(contador);
		System.out.println();

		// 9. Concatenar y convertir a mayuscula nombre y apellido
		log.debug("\n2 Concatenar y convertir a mayuscula nombre y apellido");
		jpql = "select CONCAT(p.nombre, ' ' , p.apellido) as nombre from Persona p";
		iter = em.createQuery(jpql).getResultList().iterator();
		while (iter.hasNext()) {
			String data = (String) iter.next();
			// String nombre = (String) tupla[0];

			log.debug("Nombre  " + data.toUpperCase());
		}

		// 10. Obtiene el objeto persona con id igual al parametro proporcionado
		log.debug("\n2 10. Obtiene el objeto persona con id igual al parametro proporcionado");
		jpql = "select p from Persona p where p.idPersona = :id";
		personas = em.createQuery(jpql).setParameter("id", 1l).getResultList();
		mostrarPersonas(personas);

		// 11. Obtiene las personas que tenga una l en el nombre
		log.debug("\n2 11. Obtiene las personas que tenga una l en el nombre");
		jpql = "select p from Persona p where upper(p.nombre) like upper(:nombre)";
		personas = em.createQuery(jpql).setParameter("nombre", "%l%").getResultList();
		mostrarPersonas(personas);

		// 12. uso del between
		log.debug("\n2 12. uso del between");
		jpql = "select p from Persona p where p.idPersona between :filtrar and :filtrar2";
		personas = em.createQuery(jpql).setParameter("filtrar", 1).setParameter("filtrar2", 4).getResultList();
		mostrarPersonas(personas);

		// 13. uso de ordenamiento
		log.debug("\n2 13. uso de ordenamiento");
		jpql = "select p from Persona p where p.idPersona > 3 order by p.nombre desc, p.apellido desc";
		personas = em.createQuery(jpql).getResultList();
		mostrarPersonas(personas);

		// 14. Subquerys
		log.debug("\n2 14. uso de subquerys");
		jpql = "select p from Persona p where p.idPersona in (select max(p1.idPersona) from Persona p1)";
		personas = em.createQuery(jpql).getResultList();
		mostrarPersonas(personas);

		// 15. uso de joins
		log.debug("\n2 15. uso de joins");
		jpql = "select u from Usuario u join u.idPersona p";
		List<Usuario> user = em.createQuery(jpql).getResultList();
		mostrarUsuario(user);
	}
	
	private static void mostrarUsuario(List<Usuario> usuario) {
		for (Usuario p : usuario) {
			log.debug("Persona " + p);
		}
	}

	private static void mostrarPersonas(List<Persona> personas) {
		for (Persona p : personas) {
			log.debug("Persona " + p);
		}
	}

	private static void mostrarPersonas(Persona p) {
		log.debug("Persona " + p);
	}
}
