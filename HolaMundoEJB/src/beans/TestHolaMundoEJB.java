package beans;

import javax.naming.*;

public class TestHolaMundoEJB {

	public static void main(String[] args) {
		System.out.println("Prueba de EJB");
		System.out.println("Iniciando \n");
		
		try {
			
			Context jndi = new InitialContext();
			HolaMundoEJBRemote holaMundoEJBRemote = (HolaMundoEJBRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEJBImpl!beans.HolaMundoEJBRemote");
			int resul = holaMundoEJBRemote.sumar(10, 4);
			System.out.println(resul);
			
		} catch (NamingException e) {
			e.printStackTrace(System.out);
		}
	}
	
}
