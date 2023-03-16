package com.davivienda.generarReporte.servicios.saldosCtaCteESB;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaSaldosCuentaCorrientePortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaSaldosCuentaCorrientePortType {

    @WebMethod(operationName = "ConsultaSaldosCuentaCorriente")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaSaldosCuentaCorriente", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", className = "com.davivienda.generarReporte.servicios.saldosCtaCteESB.ConsultaSaldosCuentaCorrienteType")
    @ResponseWrapper(localName = "ConsultaSaldosCuentaCorrienteResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosCuentaCorriente", className = "com.davivienda.generarReporte.servicios.saldosCtaCteESB.ConsultaSaldosCuentaCorrienteResponseType")
    ResponseType consultaSaldosCuentaCorriente(@WebParam(name = "Request", targetNamespace = "") RequestConsultaSaldosCuentaCorriente paramRequestConsultaSaldosCuentaCorriente);
}
