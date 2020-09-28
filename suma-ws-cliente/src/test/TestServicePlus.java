package test;

import clientews.servicio.ServicePlusImplService;
import clientews.servicio.ServicePlusWS;

public class TestServicePlus {

	public static void main(String[] args) {
		ServicePlusWS serviceImplService = new ServicePlusImplService().getServicePlusImplPort();
		System.out.println("Ejecutando servicio sumar");
		System.out.println(serviceImplService.sumar(4, 3));
	}
	
}
