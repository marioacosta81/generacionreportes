package co.com.davivienda.consultasproducto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(
        name = "ConsultasProductosPortType",
        targetNamespace = "http://www.davivienda.com/xml/ConsultasProductos"
)
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultasProductosPortType {

    @WebMethod(
            operationName = "ConsultasProductos",
            action = "http://www.davivienda.com/xml/ConsultasProductos"
    )
    @WebResult(
            name = "Response",
            targetNamespace = ""
    )
    @RequestWrapper(
            localName = "ConsultasProductos",
            targetNamespace = "http://www.davivienda.com/xml/ConsultasProductos",
            className = "com.davivienda.xml.consultasproductos.ConsultasProductosType"
    )
    @ResponseWrapper(
            localName = "ConsultasProductosResponse",
            targetNamespace = "http://www.davivienda.com/xml/ConsultasProductos",
            className = "com.davivienda.xml.consultasproductos.ConsultasProductosResponseType"
    )
    ResponseType consultasProductos(@WebParam(name = "Request", targetNamespace = "") RequestType var1);
}
