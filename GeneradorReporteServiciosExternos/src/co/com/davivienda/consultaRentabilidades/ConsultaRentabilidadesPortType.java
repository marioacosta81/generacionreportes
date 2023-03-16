package co.com.davivienda.consultaRentabilidades;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(
        name = "ConsultaRentabilidadesPortType",
        targetNamespace = "http://www.davivienda.com/xml/ConsultaRentabilidades"
)
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaRentabilidadesPortType {

    @WebMethod(
            operationName = "ConsultaRentabilidades",
            action = "http://www.davivienda.com/xml/ConsultaRentabilidades/ConsultaRentabilidades"
    )
    @WebResult(
            name = "Response",
            targetNamespace = ""
    )
    @RequestWrapper(
            localName = "ConsultaRentabilidades",
            targetNamespace = "http://www.davivienda.com/xml/ConsultaRentabilidades",
            className = "co.com.davivienda.consultaRentabilidades.ConsultaRentabilidadesType"
    )
    @ResponseWrapper(
            localName = "ConsultaRentabilidadesResponse",
            targetNamespace = "http://www.davivienda.com/xml/ConsultaRentabilidades",
            className = "co.com.davivienda.consultaRentabilidades.ConsultaRentabilidadesResponseType"
    )
    ResponseType consultaRentabilidades(@WebParam(name = "Request", targetNamespace = "") RequestType var1);
}
