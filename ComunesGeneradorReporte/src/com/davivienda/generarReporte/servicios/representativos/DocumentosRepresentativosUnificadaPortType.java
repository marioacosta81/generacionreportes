package com.davivienda.generarReporte.servicios.representativos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "DocumentosRepresentativosUnificadaPortType", targetNamespace = "http://www.davivienda.com/xml/DocumentosRepresentativosUnificada")
@XmlSeeAlso({ObjectFactory.class})
public interface DocumentosRepresentativosUnificadaPortType {

    @WebMethod(operationName = "DocumentosRepresentativosUnificada")
    @WebResult(name = "Response", targetNamespace = "")
    @RequestWrapper(localName = "DocumentosRepresentativosUnificada", targetNamespace = "http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", className = "com.davivienda.generarReporte.servicios.representativos.DocumentosRepresentativosUnificadaType")
    @ResponseWrapper(localName = "DocumentosRepresentativosUnificadaResponse", targetNamespace = "http://www.davivienda.com/xml/DocumentosRepresentativosUnificada", className = "com.davivienda.generarReporte.servicios.representativos.DocumentosRepresentativosUnificadaResponseType")
    ResponseDocumentosRepresentativosUnificadaType documentosRepresentativosUnificada(@WebParam(name = "Request", targetNamespace = "") RequestDocumentosRepresentativosUnificadaType paramRequestDocumentosRepresentativosUnificadaType);
}
