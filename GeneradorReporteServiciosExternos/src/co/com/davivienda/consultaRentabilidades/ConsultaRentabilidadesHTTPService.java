package co.com.davivienda.consultaRentabilidades;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(
        name = "ConsultaRentabilidades_HTTP_Service",
        targetNamespace = "http://www.davivienda.com/xml/ConsultaRentabilidades",
        wsdlLocation = "ConsultaRentabilidades.wsdl"
)
public class ConsultaRentabilidadesHTTPService extends Service {

    private static final URL CONSULTARENTABILIDADESHTTPSERVICE_WSDL_LOCATION;
    private static final WebServiceException CONSULTARENTABILIDADESHTTPSERVICE_EXCEPTION;
    private static final QName CONSULTARENTABILIDADESHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaRentabilidades", "ConsultaRentabilidades_HTTP_Service");

    public ConsultaRentabilidadesHTTPService() {
        super(__getWsdlLocation(), CONSULTARENTABILIDADESHTTPSERVICE_QNAME);
    }

    public ConsultaRentabilidadesHTTPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONSULTARENTABILIDADESHTTPSERVICE_QNAME, features);
    }

    public ConsultaRentabilidadesHTTPService(URL wsdlLocation) {
        super(wsdlLocation, CONSULTARENTABILIDADESHTTPSERVICE_QNAME);
    }

    public ConsultaRentabilidadesHTTPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONSULTARENTABILIDADESHTTPSERVICE_QNAME, features);
    }

    public ConsultaRentabilidadesHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultaRentabilidadesHTTPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(
            name = "ConsultaRentabilidadesSOAP_HTTP_Port"
    )
    public ConsultaRentabilidadesPortType getConsultaRentabilidadesSOAPHTTPPort() {
        return (ConsultaRentabilidadesPortType) super.getPort(new QName("http://www.davivienda.com/xml/ConsultaRentabilidades", "ConsultaRentabilidadesSOAP_HTTP_Port"), ConsultaRentabilidadesPortType.class);
    }

    @WebEndpoint(
            name = "ConsultaRentabilidadesSOAP_HTTP_Port"
    )
    public ConsultaRentabilidadesPortType getConsultaRentabilidadesSOAPHTTPPort(WebServiceFeature... features) {
        return (ConsultaRentabilidadesPortType) super.getPort(new QName("http://www.davivienda.com/xml/ConsultaRentabilidades", "ConsultaRentabilidadesSOAP_HTTP_Port"), ConsultaRentabilidadesPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONSULTARENTABILIDADESHTTPSERVICE_EXCEPTION != null) {
            throw CONSULTARENTABILIDADESHTTPSERVICE_EXCEPTION;
        } else {
            return CONSULTARENTABILIDADESHTTPSERVICE_WSDL_LOCATION;
        }
    }

    static {
        URL url = null;
        WebServiceException e = null;

        try {
            url = ConsultaRentabilidadesHTTPService.class.getResource("ConsultaRentabilidades.wsdl");
        } catch (Exception var3) {
            e = new WebServiceException(var3);
        }

        CONSULTARENTABILIDADESHTTPSERVICE_WSDL_LOCATION = url;
        CONSULTARENTABILIDADESHTTPSERVICE_EXCEPTION = e;
    }
}
