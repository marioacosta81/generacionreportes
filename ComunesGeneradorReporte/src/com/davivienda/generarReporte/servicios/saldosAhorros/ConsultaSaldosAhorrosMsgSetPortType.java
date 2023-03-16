package com.davivienda.generarReporte.servicios.saldosAhorros;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaSaldosAhorros_MsgSetPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosAhorros")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaSaldosAhorrosMsgSetPortType {

    @WebMethod(operationName = "ConsultaSaldosAhorros")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaSaldosAhorros", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosAhorros", className = "com.davivienda.generarReporte.servicios.consultaSaldosAhorros.ConsultaSaldosAhorrosType")
    @ResponseWrapper(localName = "ConsultaSaldosAhorrosResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosAhorros", className = "com.davivienda.generarReporte.servicios.consultaSaldosAhorros.ConsultaSaldosAhorrosResponseType")
    ResponseType consultaSaldosAhorros(@WebParam(name = "Request", targetNamespace = "") RequestType paramRequestType);
}
