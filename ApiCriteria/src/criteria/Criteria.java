package criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.gm.sga.domain.Persona;

public class Criteria {

	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		EntityManager em = Persistence.createEntityManagerFactory("SgaPu").createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Persona> criteriaQuery = null;
		Root<Persona> root = null;
		TypedQuery<Persona> query = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<>();

		// Query utilizando el api de criteria
		// 1. Consultar todas las persoans

		cb = em.getCriteriaBuilder();
		criteriaQuery = cb.createQuery(Persona.class);
		root = criteriaQuery.from(Persona.class);
		criteriaQuery.select(root);		
		query = em.createQuery(criteriaQuery);
		personas = query.getResultList();
		mostrarPersonas(personas);

		// 2. Consultar todas las personas
		// jpql = "select p from Persona p where p.idePersona = 1"
		System.out.println("Consultas persona");

		cb = em.getCriteriaBuilder();
		criteriaQuery = cb.createQuery(Persona.class);
		root = criteriaQuery.from(Persona.class);
		criteriaQuery.select(root).where(cb.equal(root.get("idPersona"), 1l));
		persona = em.createQuery(criteriaQuery).getSingleResult();
		mostrarPersonas(persona);
	}

	private static void mostrarPersonas(List<Persona> personas) {
		for (Persona lista : personas) {
			System.out.println(lista);
		}

	}
	
	private static void mostrarPersonas(Persona persona) {
		System.out.println(persona);
	}
}
