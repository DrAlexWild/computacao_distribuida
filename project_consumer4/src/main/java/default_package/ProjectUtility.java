package default_package;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.4
 * 2022-12-13T22:14:52.101Z
 * Generated source version: 3.5.4
 *
 */
@WebService(targetNamespace = "http://default_package/", name = "ProjectUtility")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectUtility {

    @WebMethod(operationName = "listar_mesas")
    @RequestWrapper(localName = "listar_mesas", targetNamespace = "http://default_package/", className = "default_package.ListarMesas")
    @ResponseWrapper(localName = "listar_mesasResponse", targetNamespace = "http://default_package/", className = "default_package.ListarMesasResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String listarMesas(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @RequestWrapper(localName = "reservar", targetNamespace = "http://default_package/", className = "default_package.Reservar")
    @ResponseWrapper(localName = "reservarResponse", targetNamespace = "http://default_package/", className = "default_package.ReservarResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String reservar(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.lang.String arg3
    );

    @WebMethod
    @RequestWrapper(localName = "cancelar", targetNamespace = "http://default_package/", className = "default_package.Cancelar")
    @ResponseWrapper(localName = "cancelarResponse", targetNamespace = "http://default_package/", className = "default_package.CancelarResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String cancelar(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.lang.String arg3
    );
}