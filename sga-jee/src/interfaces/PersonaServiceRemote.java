package interfaces;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gm.sga.domain.Persona;


//@Remote
public interface PersonaServiceRemote {

	public abstract List<Persona> listaPersona();
	public abstract Persona encontrarPersonaPorId(Persona persona);
	public abstract Persona encontrarPersonaPorEmail(Persona persona);
	public abstract void registrarPersona(Persona persona);
	public abstract void modificarPersona(Persona persona);	
	public abstract void eliminarPersona(Persona persona);

}
