package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import dto.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote {
	
	List<Persona> personas = new ArrayList<>();
	
	@Override
	public List<Persona> listaPersona() {
		personas.add(new Persona(1l, "Prueba", "Prueba", "Prueba", "Prueba"));
		personas.add(new Persona(2l, "Prueba2", "Prueba2", "Prueba2", "Prueba2"));
		return personas;
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		return null;
	}

	@Override
	public Persona encontrarPersonaPorEmail(Persona persona) {
		return null;
	}

	@Override
	public Persona registrarPersona(Persona persona) {
		return null;
	}

	@Override
	public Persona modificarPersona(Persona persona) {
		return null;
	}

	@Override
	public Persona eliminarPersona(Persona persona) {
		return null;
	}

}
