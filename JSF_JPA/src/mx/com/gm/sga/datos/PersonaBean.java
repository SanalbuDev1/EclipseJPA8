package mx.com.gm.sga.datos;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import interfaces.PersonaService;
import mx.com.gm.sga.domain.Persona;
import org.primefaces.event.*;

@Named("personaBean")
@RequestScoped
public class PersonaBean {

	@Inject
	PersonaService personaService;

	private Persona personaSeleccionada;
	List<Persona> personas;

	public PersonaBean() {

	}

	@PostConstruct
	public void inicializar() {
		personas = personaService.listaPersona();
		personaSeleccionada = new Persona();
	}

	public void editListener(RowEditEvent row) {
		Persona persona = (Persona) row.getObject();
		personaService.modificarPersona(persona);
	}

	public void agregarPersona() {
		this.personaService.registrarPersona(this.personaSeleccionada);
		this.personas.add(this.personaSeleccionada);
		personaSeleccionada = null;
	}

	public void eliminarPersona() {
		this.personaService.eliminarPersona(this.personaSeleccionada);
		this.personas.remove(this.personaSeleccionada);
		this.personaSeleccionada = null;
	}
	
	public void reiniciarPersonaSeleccionada() {
		this.personaSeleccionada = new Persona();
	}
	
	public Persona getPersonaSeleccionada() {
		return personaSeleccionada;
	}

	public void setPersonaSeleccionada(Persona personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}
