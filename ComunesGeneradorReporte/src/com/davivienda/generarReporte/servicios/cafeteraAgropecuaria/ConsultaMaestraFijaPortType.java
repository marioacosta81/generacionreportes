package com.davivienda.generarReporte.servicios.cafeteraAgropecuaria;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "ConsultaMaestraFijaPortType", targetNamespace = "http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaMaestraFijaPortType {

    @WebMethod(operationName = "ConsultaMaestraFija")
    @WebResult(name = "ConsTotTCCafAgrResponse", targetNamespace = "http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", partName = "ConsTotTCCafAgrResponse")
    ConsTotTCCafAgrResponseType consultaMaestraFija(@WebParam(name = "ConsTotTCCafAgrRequest", targetNamespace = "http://www.davivienda.com/xml/ConsultaTotalesTarjetaCreditoCafeteraAgropecuaria", partName = "ConsTotTCCafAgrRequest") ConsTotTCCafAgrRequestType paramConsTotTCCafAgrRequestType);
}
