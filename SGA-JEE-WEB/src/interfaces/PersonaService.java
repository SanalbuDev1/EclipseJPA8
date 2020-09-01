package interfaces;

import java.util.List;

import javax.ejb.Local;

import mx.com.gm.sga.domain.Persona;


@Local
public interface PersonaService {

	public abstract List<Persona> listaPersona();

	public abstract Persona encontrarPersonaPorId(Persona persona);

	public abstract Persona encontrarPersonaPorEmail(Persona persona);

	public abstract void registrarPersona(Persona persona);

	public abstract void modificarPersona(Persona persona);

	public abstract void eliminarPersona(Persona persona);

}
