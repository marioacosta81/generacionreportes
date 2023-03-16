package com.davivienda.generarReporte.servicios.consultaHipotecario;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaDetalleCredHipotecarioLeasingPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaDetalleCredHipotecarioLeasingPortType {

    @WebMethod(operationName = "ConsultaDetalleCredHipotecarioLeasing")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaDetalleCredHipotecarioLeasing", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", className = "com.davivienda.generarReporte.servicios.consultaHipotecario.ConsultaDetalleCredHipotecarioLeasingType")
    @ResponseWrapper(localName = "ConsultaDetalleCredHipotecarioLeasingResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleCredHipotecarioLeasing", className = "com.davivienda.generarReporte.servicios.consultaHipotecario.ConsultaDetalleCredHipotecarioLeasingResponseType")
    ResponseType consultaDetalleCredHipotecarioLeasing(@WebParam(name = "Request", targetNamespace = "") RequestConsultaDetalleCredHipotecarioLeasing paramRequestConsultaDetalleCredHipotecarioLeasing);
}
