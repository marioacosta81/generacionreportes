package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaCertificadoProductoResType", propOrder = {"response"})
public class ConsultaCertificadoProductoResType {

    @XmlElement(name = "Response", required = true)
    protected ConsultaCertificadoProductoResponseType response;

    public ConsultaCertificadoProductoResType() {
        super();
    }

    public ConsultaCertificadoProductoResponseType getResponse() {
        return this.response;
    }

    public void setResponse(final ConsultaCertificadoProductoResponseType value) {
        this.response = value;
    }
}
