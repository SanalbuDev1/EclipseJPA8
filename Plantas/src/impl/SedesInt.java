package impl;

import java.util.List;

import javax.ejb.Local;
import javax.inject.Inject;

import entidades.Sedes;
import interfaces.SedesI;


@Local
public interface SedesInt {
	
	public List<Sedes> findAll();
	
}
