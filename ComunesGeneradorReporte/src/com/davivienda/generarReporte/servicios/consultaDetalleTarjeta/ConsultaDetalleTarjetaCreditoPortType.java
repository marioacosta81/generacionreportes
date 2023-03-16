package com.davivienda.generarReporte.servicios.consultaDetalleTarjeta;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaDetalleTarjetaCreditoPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaDetalleTarjetaCreditoPortType {

    @WebMethod(operationName = "ConsultaDetalleTarjetaCredito")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaDetalleTarjetaCredito", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", className = "com.davivienda.generarReporte.servicios.consultaDetalleTarjeta.ConsultaDetalleTarjetaCreditoType")
    @ResponseWrapper(localName = "ConsultaDetalleTarjetaCreditoResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaDetalleTarjetaCredito", className = "com.davivienda.generarReporte.servicios.consultaDetalleTarjeta.ConsultaDetalleTarjetaCreditoResponseType")
    ResponseType consultaDetalleTarjetaCredito(@WebParam(name = "Request", targetNamespace = "") RequestConsultaDetalleTarjetaCredito paramRequestConsultaDetalleTarjetaCredito);
}
