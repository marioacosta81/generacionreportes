package co.com.davivienda.consultaRentabilidades;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private static final QName _ConsultaRentabilidades_QNAME = new QName("http://www.davivienda.com/xml/ConsultaRentabilidades", "ConsultaRentabilidades");
    private static final QName _ConsultaRentabilidadesResponse_QNAME = new QName("http://www.davivienda.com/xml/ConsultaRentabilidades", "ConsultaRentabilidadesResponse");

    public ConsultaRentabilidadesType createConsultaRentabilidadesType() {
        return new ConsultaRentabilidadesType();
    }

    public ConsultaRentabilidadesResponseType createConsultaRentabilidadesResponseType() {
        return new ConsultaRentabilidadesResponseType();
    }

    public ARRRentabilidadesRespType createARRRentabilidadesRespType() {
        return new ARRRentabilidadesRespType();
    }

    public ResponseType createResponseType() {
        return new ResponseType();
    }

    public EtiquetaType createEtiquetaType() {
        return new EtiquetaType();
    }

    public ARRRentabilidadesType createARRRentabilidadesType() {
        return new ARRRentabilidadesType();
    }

    public DataReqType createDataReqType() {
        return new DataReqType();
    }

    public ARRFondosRespType createARRFondosRespType() {
        return new ARRFondosRespType();
    }

    public ARRParticipacionesType createARRParticipacionesType() {
        return new ARRParticipacionesType();
    }

    public DataRespType createDataRespType() {
        return new DataRespType();
    }

    public DataHeaderReqType createDataHeaderReqType() {
        return new DataHeaderReqType();
    }

    public EtiquetasRentaRespType createEtiquetasRentaRespType() {
        return new EtiquetasRentaRespType();
    }

    public FondoSRespType createFondoSRespType() {
        return new FondoSRespType();
    }

    public EtiquetasType createEtiquetasType() {
        return new EtiquetasType();
    }

    public DataHeaderRespType createDataHeaderRespType() {
        return new DataHeaderRespType();
    }

    public RentaParticipacionRespType createRentaParticipacionRespType() {
        return new RentaParticipacionRespType();
    }

    public RentabilidadesRespType createRentabilidadesRespType() {
        return new RentabilidadesRespType();
    }

    public ParticipacionesRespType createParticipacionesRespType() {
        return new ParticipacionesRespType();
    }

    public RequestType createRequestType() {
        return new RequestType();
    }

    @XmlElementDecl(
            namespace = "http://www.davivienda.com/xml/ConsultaRentabilidades",
            name = "ConsultaRentabilidades"
    )
    public JAXBElement<ConsultaRentabilidadesType> createConsultaRentabilidades(ConsultaRentabilidadesType value) {
        return new JAXBElement(_ConsultaRentabilidades_QNAME, ConsultaRentabilidadesType.class, (Class) null, value);
    }

    @XmlElementDecl(
            namespace = "http://www.davivienda.com/xml/ConsultaRentabilidades",
            name = "ConsultaRentabilidadesResponse"
    )
    public JAXBElement<ConsultaRentabilidadesResponseType> createConsultaRentabilidadesResponse(ConsultaRentabilidadesResponseType value) {
        return new JAXBElement(_ConsultaRentabilidadesResponse_QNAME, ConsultaRentabilidadesResponseType.class, (Class) null, value);
    }
}
