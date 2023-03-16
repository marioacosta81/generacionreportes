package co.com.davivienda.consultasproducto;

import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceFeature;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;
import java.net.URL;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.Service;

@WebServiceClient(name = "ConsultasProductos_HTTP_Service", targetNamespace = "http://www.davivienda.com/xml/ConsultasProductos", wsdlLocation = "ConsultasProductos_1.wsdl")
public class ConsultasProductosHTTPService extends Service {

    private static final URL CONSULTASPRODUCTOSHTTPSERVICE_WSDL_LOCATION;
    private static final WebServiceException CONSULTASPRODUCTOSHTTPSERVICE_EXCEPTION;
    private static final QName CONSULTASPRODUCTOSHTTPSERVICE_QNAME;

    public ConsultasProductosHTTPService() {
        super(__getWsdlLocation(), ConsultasProductosHTTPService.CONSULTASPRODUCTOSHTTPSERVICE_QNAME);
    }

    public ConsultasProductosHTTPService(final WebServiceFeature... features) {
        super(__getWsdlLocation(), ConsultasProductosHTTPService.CONSULTASPRODUCTOSHTTPSERVICE_QNAME, features);
    }

    public ConsultasProductosHTTPService(final URL wsdlLocation) {
        super(wsdlLocation, ConsultasProductosHTTPService.CONSULTASPRODUCTOSHTTPSERVICE_QNAME);
    }

    public ConsultasProductosHTTPService(final URL wsdlLocation, final WebServiceFeature... features) {
        super(wsdlLocation, ConsultasProductosHTTPService.CONSULTASPRODUCTOSHTTPSERVICE_QNAME, features);
    }

    public ConsultasProductosHTTPService(final URL wsdlLocation, final QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultasProductosHTTPService(final URL wsdlLocation, final QName serviceName, final WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "ConsultasProductosSOAP_HTTP_Port")
    public ConsultasProductosPortType getConsultasProductosSOAPHTTPPort() {
        return super.getPort(new QName("http://www.davivienda.com/xml/ConsultasProductos", "ConsultasProductosSOAP_HTTP_Port"), ConsultasProductosPortType.class);
    }

    @WebEndpoint(name = "ConsultasProductosSOAP_HTTP_Port")
    public ConsultasProductosPortType getConsultasProductosSOAPHTTPPort(final WebServiceFeature... features) {
        return super.getPort(new QName("http://www.davivienda.com/xml/ConsultasProductos", "ConsultasProductosSOAP_HTTP_Port"), ConsultasProductosPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ConsultasProductosHTTPService.CONSULTASPRODUCTOSHTTPSERVICE_EXCEPTION != null) {
            throw ConsultasProductosHTTPService.CONSULTASPRODUCTOSHTTPSERVICE_EXCEPTION;
        }
        return ConsultasProductosHTTPService.CONSULTASPRODUCTOSHTTPSERVICE_WSDL_LOCATION;
    }

    static {
        CONSULTASPRODUCTOSHTTPSERVICE_QNAME = new QName("http://www.davivienda.com/xml/ConsultasProductos", "ConsultasProductos_HTTP_Service");
        URL url = null;
        WebServiceException e = null;
        try {
            url = ConsultasProductosHTTPService.class.getResource("ConsultasProductos_1.wsdl");
        } catch (Exception ex) {
            e = new WebServiceException(ex);
        }
        CONSULTASPRODUCTOSHTTPSERVICE_WSDL_LOCATION = url;
        CONSULTASPRODUCTOSHTTPSERVICE_EXCEPTION = e;
    }
}
