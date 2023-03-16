package com.davivienda.generarReporte.servicios.fondosInversion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "SAF_MsgSetPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaFondosDeInversion")
@XmlSeeAlso({ObjectFactory.class})
public interface SAFMsgSetPortType {

    @WebMethod(operationName = "ConsultaFondosDeInversion")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaFondosDeInversion", targetNamespace = "http://www.davivienda.com/xml/ConsultaFondosDeInversion", className = "com.davivienda.generarReporte.servicios.consultaFondosInv.ConsultaFondosDeInversion")
    @ResponseWrapper(localName = "ConsultaFondosDeInversionResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaFondosDeInversion", className = "com.davivienda.generarReporte.servicios.consultaFondosInv.ConsultaFondosDeInversionResponse")
    ResponseConsultaFondosDeInversion consultaFondosDeInversion(@WebParam(name = "Request", targetNamespace = "") RequestConsultaFondosDeInversion paramRequestConsultaFondosDeInversion);
}
