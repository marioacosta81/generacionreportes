package com.davivienda.generarReporte.servicios.productoNoConsumo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "ConsultaSaldosProductoNoConsumoPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaSaldosProductoNoConsumoPortType {

    @WebMethod(operationName = "ConsultaSaldosProductoNoConsumo")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "ConsultaSaldosProductoNoConsumo", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", className = "com.davivienda.generarReporte.servicios.productoNoConsumo.ConsultaSaldosProductoNoConsumoType")
    @ResponseWrapper(localName = "ConsultaSaldosProductoNoConsumoResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaSaldosProductoNoConsumo", className = "com.davivienda.generarReporte.servicios.productoNoConsumo.ConsultaSaldosProductoNoConsumoResponseType")
    ResponseType consultaSaldosProductoNoConsumo(@WebParam(name = "Request", targetNamespace = "") RequestConsultaSaldosProductoNoConsumo paramRequestConsultaSaldosProductoNoConsumo);
}
