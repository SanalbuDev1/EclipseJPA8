package prueba;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entidades.Maquina;
import entidades.NumeroIdentificacion;
import entidades.Planta;
import entidades.PlantaInsumos;
import entidades.Sedes;


import java.math.BigInteger;

public class Prueba {

	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		String jpql = null;
		Query q = null;
		List<Sedes> sedes = null;
		Sedes sede = null;
		Iterator iter = null;
		Object[] tupla = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		/* Se consultara para revisar funcionalidad de 3 entidades */

		// Consulta maquinas
		log.debug("Consultando todas las maquinas ");
		jpql = "select m from Maquina m";
		List<Maquina> mquina = em.createQuery(jpql).getResultList();

		for (Maquina lista : mquina) {
			log.debug(lista.getNombre());
		}

		System.out.println();
		System.out.println();

		// Consulta sedes
		log.debug("Consultando todas las sedes ");
		jpql = "select m from Sedes m";
		sedes = em.createQuery(jpql).getResultList();

		for (Sedes lista : sedes) {
			log.debug(lista.getNombre());
			for (Planta planta : lista.getPlantaList()) {
				System.out.println(planta.getNombre());
			}
		}

		System.out.println();
		System.out.println();

		/* Se trabajara con insumos y plantas */
		// Consultas insumos

		// Consultas insumos con su FK de numero de identificaciom
		log.debug("Consultando todas los insumos ");
		Query nativeQuery = em.createNativeQuery(
				"SELECT n.id_numero_identificacion, n.nombre , n.descripcion FROM planta.insumos p, planta.numero_identificacion n where p.id_numero_identificacion_fk = n.id_numero_identificacion");

		List<Object[]> results = nativeQuery.getResultList();

		List<NumeroIdentificacion> numeroIdentificacions = new ArrayList<>();
		numeroIdentificacions = results.stream()
				.map(result -> new NumeroIdentificacion(((Integer) result[0]), (String) result[1], (String) result[2]))
				.collect(Collectors.toList());

		for (int i = 0; i < numeroIdentificacions.size(); i++) {
			System.out.println("Id " + numeroIdentificacions.get(i).getIdNumeroIdentificacion() + " Nombre "
					+ numeroIdentificacions.get(i).getNombre());
		}

		System.out.println();
		System.out.println();

		// Consutar planta_insumos
		
		log.debug("Consultando todas las plantas_insumos ");
		jpql = "select m from PlantaInsumos m";
		List<PlantaInsumos> plantaInsumo = em.createQuery(jpql).getResultList();

		for (PlantaInsumos lista : plantaInsumo) {
			System.out.println(lista);
		}
		
		/*
		 * PlantaInsumos [idplantaInsumos=1, cantitadTotal=1000.0, idInsumosFk=entidadades.Insumos[ idInsumos=1 ], idPlantaFk=entidades.Planta[ idPlantas=1 ]]
			PlantaInsumos [idplantaInsumos=2, cantitadTotal=1000.0, idInsumosFk=entidadades.Insumos[ idInsumos=2 ], idPlantaFk=entidades.Planta[ idPlantas=1 ]]
		 * */
		
		// Consumir 20l de gasolina de la planta 1
		
		
		
		tx.begin();
		
		PlantaInsumos planta = em.find(PlantaInsumos.class, 1);		
		planta.setCantitadTotal(planta.getCantitadTotal()-20);		
		em.merge(planta);		
		log.debug("Usuario actualizado " + planta);		
		tx.commit();
		log.debug("Usuario Actualizado " + planta);		
		PlantaInsumos planta2 = em.find(PlantaInsumos.class, 1);
		System.out.println(planta2.getCantitadTotal());

	}
}
