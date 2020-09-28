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
	
	private Persona personaSelecionada;
	List<Persona> personas;
	
	public PersonaBean() {
		
	}
	
	@PostConstruct
	public void inicializar() {
		personas = personaService.listaPersona();
		personaSelecionada = new Persona();
	}
	
	public void editListener(RowEditEvent row) {
		Persona persona = (Persona) row.getObject();
		personaService.modificarPersona(persona);
	}

	public Persona getPersonaSelecionada() {
		return personaSelecionada;
	}

	public void setPersonaSelecionada(Persona personaSelecionada) {
		this.personaSelecionada = personaSelecionada;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}
