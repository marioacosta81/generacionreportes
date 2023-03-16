package com.davivienda.generarReporte.servicios.consultaDivisas;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaDeDivisasPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaDeDivisas")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaDeDivisasPortType {

    @WebMethod(operationName = "ConsultaDeDivisas")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaDeDivisas", targetNamespace = "http://www.davivienda.com/xml/ConsultaDeDivisas", className = "com.davivienda.generarReporte.servicios.consultaDivisas.ConsultaDeDivisasType")
    @ResponseWrapper(localName = "ConsultaDeDivisasResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaDeDivisas", className = "com.davivienda.generarReporte.servicios.consultaDivisas.ConsultaDeDivisasResponseType")
    ResponseType consultaDeDivisas(@WebParam(name = "Request", targetNamespace = "") RequestConsultaDeDivisas paramRequestConsultaDeDivisas);
}
