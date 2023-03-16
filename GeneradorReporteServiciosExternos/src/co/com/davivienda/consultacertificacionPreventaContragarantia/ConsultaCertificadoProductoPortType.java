package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.RequestWrapper;
import javax.jws.WebResult;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.jws.WebService;

@WebService(name = "ConsultaCertificadoProductoPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaCertificadoProducto")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaCertificadoProductoPortType {

    @WebMethod(operationName = "ConsultaCertificadoProducto")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaCertificadoProducto", targetNamespace = "http://www.davivienda.com/xml/ConsultaCertificadoProducto", className = "co.com.davivienda.consultacertificacionPreventaContragarantia.ConsultaCertificadoProductoType")
    @ResponseWrapper(localName = "ConsultaCertificadoProductoResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaCertificadoProducto", className = "co.com.davivienda.consultacertificacionPreventaContragarantia.ConsultaCertificadoProductoResType")
    ConsultaCertificadoProductoResponseType consultaCertificadoProducto(@WebParam(name = "Request", targetNamespace = "") final ConsultaCertificadoProductoRequestType p0);
}
