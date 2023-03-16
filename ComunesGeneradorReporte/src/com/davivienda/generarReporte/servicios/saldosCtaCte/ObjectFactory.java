package com.davivienda.generarReporte.servicios.saldosCtaCte;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaSaldoCuentaCorrienteResponse_QNAME = new QName("http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", "consultaSaldoCuentaCorrienteResponse");
    private static final QName _ConsultaSaldoCuentaCorriente_QNAME = new QName("http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", "consultaSaldoCuentaCorriente");
    private static final QName _ServicioException_QNAME = new QName("http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", "ServicioException");

    public ConsultaSaldoCuentaCorrienteResponse createConsultaSaldoCuentaCorrienteResponse() {
        return new ConsultaSaldoCuentaCorrienteResponse();
    }

    public ServicioException createServicioException() {
        return new ServicioException();
    }

    public ConsultaSaldoCuentaCorriente createConsultaSaldoCuentaCorriente() {
        return new ConsultaSaldoCuentaCorriente();
    }

    public RespuestaDeTransaccionBaseDTO createRespuestaDeTransaccionBaseDTO() {
        return new RespuestaDeTransaccionBaseDTO();
    }

    public ConsultaSaldoCuentaCorrienteIIDto createConsultaSaldoCuentaCorrienteIIDto() {
        return new ConsultaSaldoCuentaCorrienteIIDto();
    }

    public RespuestaConsultaSaldoCuentaCorrienteIIDto createRespuestaConsultaSaldoCuentaCorrienteIIDto() {
        return new RespuestaConsultaSaldoCuentaCorrienteIIDto();
    }

    public ParametrosSeguridadDTO createParametrosSeguridadDTO() {
        return new ParametrosSeguridadDTO();
    }

    public ParametrosDeTransaccionBaseDTO createParametrosDeTransaccionBaseDTO() {
        return new ParametrosDeTransaccionBaseDTO();
    }

    public CampoExtendidoDto createCampoExtendidoDto() {
        return new CampoExtendidoDto();
    }

    public CampoDto createCampoDto() {
        return new CampoDto();
    }

    @XmlElementDecl(namespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", name = "consultaSaldoCuentaCorrienteResponse")
    public JAXBElement<ConsultaSaldoCuentaCorrienteResponse> createConsultaSaldoCuentaCorrienteResponse(ConsultaSaldoCuentaCorrienteResponse value) {
        return new JAXBElement<ConsultaSaldoCuentaCorrienteResponse>(_ConsultaSaldoCuentaCorrienteResponse_QNAME, ConsultaSaldoCuentaCorrienteResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", name = "consultaSaldoCuentaCorriente")
    public JAXBElement<ConsultaSaldoCuentaCorriente> createConsultaSaldoCuentaCorriente(ConsultaSaldoCuentaCorriente value) {
        return new JAXBElement<ConsultaSaldoCuentaCorriente>(_ConsultaSaldoCuentaCorriente_QNAME, ConsultaSaldoCuentaCorriente.class, null, value);
    }

    @XmlElementDecl(namespace = "http://consultasaldocuentacorriente.servicio.procesadortransacciones.davivienda.com/", name = "ServicioException")
    public JAXBElement<ServicioException> createServicioException(ServicioException value) {
        return new JAXBElement<ServicioException>(_ServicioException_QNAME, ServicioException.class, null, value);
    }
}
