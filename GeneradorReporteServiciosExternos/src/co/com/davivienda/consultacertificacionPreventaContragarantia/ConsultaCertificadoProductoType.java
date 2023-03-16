package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ConsultaCertificadoProductoType",
        propOrder = {"request"}
)
public class ConsultaCertificadoProductoType {

    @XmlElement(
            name = "Request",
            required = true
    )
    protected ConsultaCertificadoProductoRequestType request;

    public ConsultaCertificadoProductoRequestType getRequest() {
        return this.request;
    }

    public void setRequest(ConsultaCertificadoProductoRequestType value) {
        this.request = value;
    }
}
