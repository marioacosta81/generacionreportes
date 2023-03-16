package com.davivienda.generarReporte.servicios.consultaCartera;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaCartera_QNAME = new QName("http://servicios.davivienda.com/consultaCarteraServiceTypes", "consultaCartera");
    private static final QName _ServicioException_QNAME = new QName("http://servicios.davivienda.com/consultaCarteraServiceTypes", "ServicioException");
    private static final QName _ConsultaCarteraResponse_QNAME = new QName("http://servicios.davivienda.com/consultaCarteraServiceTypes", "consultaCarteraResponse");

    public ConsultaCarteraResponse createConsultaCarteraResponse() {
        return new ConsultaCarteraResponse();
    }

    public ServicioException createServicioException() {
        return new ServicioException();
    }

    public ConsultaCartera createConsultaCartera() {
        return new ConsultaCartera();
    }

    public RespuestaConsultaCarteraDto createRespuestaConsultaCarteraDto() {
        return new RespuestaConsultaCarteraDto();
    }

    public ConsultaCarteraDto createConsultaCarteraDto() {
        return new ConsultaCarteraDto();
    }

    public RespConsultaCarteraRepDto createRespConsultaCarteraRepDto() {
        return new RespConsultaCarteraRepDto();
    }

    public CampoExtendidoDto createCampoExtendidoDto() {
        return new CampoExtendidoDto();
    }

    public ParametrosSeguridadDTO createParametrosSeguridadDTO() {
        return new ParametrosSeguridadDTO();
    }

    @XmlElementDecl(namespace = "http://servicios.davivienda.com/consultaCarteraServiceTypes", name = "consultaCartera")
    public JAXBElement<ConsultaCartera> createConsultaCartera(ConsultaCartera value) {
        return new JAXBElement<ConsultaCartera>(_ConsultaCartera_QNAME, ConsultaCartera.class, null, value);
    }

    @XmlElementDecl(namespace = "http://servicios.davivienda.com/consultaCarteraServiceTypes", name = "ServicioException")
    public JAXBElement<ServicioException> createServicioException(ServicioException value) {
        return new JAXBElement<ServicioException>(_ServicioException_QNAME, ServicioException.class, null, value);
    }

    @XmlElementDecl(namespace = "http://servicios.davivienda.com/consultaCarteraServiceTypes", name = "consultaCarteraResponse")
    public JAXBElement<ConsultaCarteraResponse> createConsultaCarteraResponse(ConsultaCarteraResponse value) {
        return new JAXBElement<ConsultaCarteraResponse>(_ConsultaCarteraResponse_QNAME, ConsultaCarteraResponse.class, null, value);
    }
}
