package com.davivienda.generarReporte.servicios.consultaCartera;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaCarteraServiceInterface", targetNamespace = "http://servicios.davivienda.com/consultaCarteraService")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaCarteraServiceInterface {

    @WebMethod
    @WebResult(name = "result", targetNamespace = "")
    @RequestWrapper(localName = "consultaCartera", targetNamespace = "http://servicios.davivienda.com/consultaCarteraServiceTypes", className = "com.davivienda.generarReporte.servicios.consultaCartera.ConsultaCartera")
    @ResponseWrapper(localName = "consultaCarteraResponse", targetNamespace = "http://servicios.davivienda.com/consultaCarteraServiceTypes", className = "com.davivienda.generarReporte.servicios.consultaCartera.ConsultaCarteraResponse")
    RespuestaConsultaCarteraDto consultaCartera(@WebParam(name = "ConsultaCarteraDto_1", targetNamespace = "") ConsultaCarteraDto paramConsultaCarteraDto) throws ServicioException_Exception;
}
