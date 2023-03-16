package com.davivienda.generarReporte.servicios.dabuenavida;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaSaldoTituloDabuenavidaPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaSaldoTituloDabuenavidaPortType {

    @WebMethod(operationName = "ConsultaSaldoTituloDabuenavida")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaSaldoTituloDabuenavida", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", className = "com.davivienda.generarReporte.servicios.dabuenavida.ConsultaSaldoTituloDabuenavidaType")
    @ResponseWrapper(localName = "ConsultaSaldoTituloDabuenavidaResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldoTituloDabuenavida", className = "com.davivienda.generarReporte.servicios.dabuenavida.ConsultaSaldoTituloDabuenavidaResponseType")
    ResponseType consultaSaldoTituloDabuenavida(@WebParam(name = "Request", targetNamespace = "") RequestConsultaSaldoTituloDabuenavida paramRequestConsultaSaldoTituloDabuenavida);
}
