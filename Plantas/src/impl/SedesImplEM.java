package impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import entidades.Sedes;
import interfaces.SedesI;


@Stateless
public class SedesImplEM implements SedesInt  {

	@Inject
	private SedesI sedesI;
	
	@Override
	public List<Sedes> findAll() {
		// TODO Auto-generated method stub
		return sedesI.findAll();
	}

}
