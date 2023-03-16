package com.davivienda.generarReporte.servicios.consultaSaldosCredFecha;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaSaldosCredFechaCortePortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaSaldosCredFechaCortePortType {

    @WebMethod(operationName = "ConsultaSaldosCredFechaCorte")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaSaldosCredFechaCorte", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", className = "com.davivienda.generarReporte.servicios.consultaSaldosCredFecha.ConsultaSaldosCredFechaCorteType")
    @ResponseWrapper(localName = "ConsultaSaldosCredFechaCorteResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCredFechaCorte", className = "com.davivienda.generarReporte.servicios.consultaSaldosCredFecha.ConsultaSaldosCredFechaCorteResponseType")
    ResponseType consultaSaldosCredFechaCorte(@WebParam(name = "Request", targetNamespace = "") RequestConsultaSaldosCredFechaCorte paramRequestConsultaSaldosCredFechaCorte);
}
