package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceFeature;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;
import java.net.URL;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.Service;

@WebServiceClient(name = "ConsultaCertificadoProducto_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultaCertificadoProducto", wsdlLocation = "ConsultaCertificadoProductoService.wsdl")
public class ConsultaCertificadoProductoHTTPService extends Service {

    private static final URL CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_WSDL_LOCATION;
    private static final WebServiceException CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_EXCEPTION;
    private static final QName CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_QNAME;

    public ConsultaCertificadoProductoHTTPService() {
        super(__getWsdlLocation(), ConsultaCertificadoProductoHTTPService.CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_QNAME);
    }

    public ConsultaCertificadoProductoHTTPService(final WebServiceFeature... features) {
        super(__getWsdlLocation(), ConsultaCertificadoProductoHTTPService.CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_QNAME, features);
    }

    public ConsultaCertificadoProductoHTTPService(final URL wsdlLocation) {
        super(wsdlLocation, ConsultaCertificadoProductoHTTPService.CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_QNAME);
    }

    public ConsultaCertificadoProductoHTTPService(final URL wsdlLocation, final WebServiceFeature... features) {
        super(wsdlLocation, ConsultaCertificadoProductoHTTPService.CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_QNAME, features);
    }

    public ConsultaCertificadoProductoHTTPService(final URL wsdlLocation, final QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultaCertificadoProductoHTTPService(final URL wsdlLocation, final QName serviceName, final WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "ConsultaCertificadoProducto_HTTP_Port")
    public ConsultaCertificadoProductoPortType getConsultaCertificadoProductoHTTPPort() {
        return super.getPort(new QName("http://www.davivienda.com/xml/ConsultaCertificadoProducto", "ConsultaCertificadoProducto_HTTP_Port"), ConsultaCertificadoProductoPortType.class);
    }

    @WebEndpoint(name = "ConsultaCertificadoProducto_HTTP_Port")
    public ConsultaCertificadoProductoPortType getConsultaCertificadoProductoHTTPPort(final WebServiceFeature... features) {
        return super.getPort(new QName("http://www.davivienda.com/xml/ConsultaCertificadoProducto", "ConsultaCertificadoProducto_HTTP_Port"), ConsultaCertificadoProductoPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ConsultaCertificadoProductoHTTPService.CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_EXCEPTION != null) {
            throw ConsultaCertificadoProductoHTTPService.CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_EXCEPTION;
        }
        return ConsultaCertificadoProductoHTTPService.CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_WSDL_LOCATION;
    }

    static {
        CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultaCertificadoProducto", "ConsultaCertificadoProducto_HTTP_Service");
        URL url = null;
        WebServiceException e = null;
        try {
            url = ConsultaCertificadoProductoHTTPService.class.getResource("ConsultaCertificadoProductoService.wsdl");
        } catch (Exception ex) {
            e = new WebServiceException(ex);
        }
        CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_WSDL_LOCATION = url;
        CONSULTACERTIFICADOPRODUCTOHTTPSERVICE_EXCEPTION = e;
    }
}
