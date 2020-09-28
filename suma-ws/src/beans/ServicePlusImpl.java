package beans;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "beans.ServicePlusWS")
public class ServicePlusImpl implements ServicePlusWS {

	@Override
	public int sumar(int a, int b) {
		return a+b;
	}

}
