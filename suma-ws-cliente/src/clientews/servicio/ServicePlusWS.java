
package clientews.servicio;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicePlusWS", targetNamespace = "http://beans/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicePlusWS {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sumar", targetNamespace = "http://beans/", className = "clientews.servicio.Sumar")
    @ResponseWrapper(localName = "sumarResponse", targetNamespace = "http://beans/", className = "clientews.servicio.SumarResponse")
    @Action(input = "http://beans/ServicePlusWS/sumarRequest", output = "http://beans/ServicePlusWS/sumarResponse")
    public int sumar(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
