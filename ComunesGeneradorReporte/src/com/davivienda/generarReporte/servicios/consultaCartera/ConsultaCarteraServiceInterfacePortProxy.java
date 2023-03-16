package com.davivienda.generarReporte.servicios.consultaCartera;

import java.net.URL;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class ConsultaCarteraServiceInterfacePortProxy {

    protected Descriptor _descriptor;

    public class Descriptor {

        private ConsultaCarteraService _service = null;
        private ConsultaCarteraServiceInterface _proxy = null;
        private Dispatch<Source> _dispatch = null;

        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            this._service = new ConsultaCarteraService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            this._service = null;
            this._proxy = null;
            this._dispatch = null;

            try {
                InitialContext ctx = new InitialContext();
                this._service = (ConsultaCarteraService) ctx.lookup("java:comp/env/service/ConsultaCarteraService");
            } catch (NamingException e) {

                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            initCommon();
        }

        private void initCommon() {
            this._proxy = this._service.getConsultaCarteraServiceInterfacePort();
        }

        public ConsultaCarteraServiceInterface getProxy() {
            return this._proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            this._useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (this._dispatch == null) {
                QName portQName = new QName("", "ConsultaCarteraServiceInterfacePort");
                this._dispatch = this._service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = this._dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get("javax.xml.ws.service.endpoint.address");
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl)) {
                    bp.getRequestContext().put("javax.xml.ws.service.endpoint.address", proxyEndpointUrl);
                }
            }
            return this._dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) this._proxy;
            return (String) bp.getRequestContext().get("javax.xml.ws.service.endpoint.address");
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) this._proxy;
            bp.getRequestContext().put("javax.xml.ws.service.endpoint.address", endpointUrl);

            if (this._dispatch != null) {
                bp = this._dispatch;
                bp.getRequestContext().put("javax.xml.ws.service.endpoint.address", endpointUrl);
            }
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) this._proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public ConsultaCarteraServiceInterfacePortProxy() {
        this._descriptor = new Descriptor();
        this._descriptor.setMTOMEnabled(false);
    }

    public ConsultaCarteraServiceInterfacePortProxy(URL wsdlLocation, QName serviceName) {
        this._descriptor = new Descriptor(wsdlLocation, serviceName);
        this._descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return this._descriptor;
    }

    public RespuestaConsultaCarteraDto consultaCartera(ConsultaCarteraDto consultaCarteraDto1) throws ServicioException_Exception {
        return _getDescriptor().getProxy().consultaCartera(consultaCarteraDto1);
    }
}
