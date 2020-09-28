package test;

import java.util.List;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWs;

public class test {

	public static void main(String[] args) {
		PersonaServiceWs personaServiceWs = new PersonaServiceImplService().getPersonaServiceImplPort();
		List<Persona> personas = personaServiceWs.listarPersonas();
		Persona personaBuscar = new Persona();
		personaBuscar.setIdPersona(1l);
		Persona per = personaServiceWs.listarPersonaUna(personaBuscar);
		
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i).getEmail());
		}
		
		System.out.println("otro metodo");
		System.out.println(per.getIdPersona());
	}
	
}
