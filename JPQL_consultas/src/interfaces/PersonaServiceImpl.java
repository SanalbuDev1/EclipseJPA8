package interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.com.gm.sga.datos.PersonaDao;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;



@Stateless
public class PersonaServiceImpl implements PersonaService {
	
	@Inject
	private PersonaDao dao;	
	
	List<Persona> personas = new ArrayList<>();
	
	@Override
	public List<Persona> listaPersona() {
		return dao.listaPersona();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		return dao.encontrarPersonaPorId(persona);
	}

	@Override
	public Persona encontrarPersonaPorEmail(Persona persona) {
		return dao.encontrarPersonaPorEmail(persona);
	}

	@Override
	public void registrarPersona(Persona persona) {
		dao.registrarPersona(persona);
	}

	@Override
	public void modificarPersona(Persona persona) {
		dao.modificarPersona(persona);
	}

	@Override
	public void eliminarPersona(Persona persona) {
		dao.eliminarPersona(persona);
	}

	//usuario
	
	@Override
	public List<Usuario> listaUsuario() {
		// TODO Auto-generated method stub
		return dao.listaUsuario();
	}

	@Override
	public Usuario encontrarUsuarioPorId(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.encontrarUsuarioPorId(usuario);
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.registrarUsuario(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.modificarUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.eliminarUsuario(usuario);
	}

}
