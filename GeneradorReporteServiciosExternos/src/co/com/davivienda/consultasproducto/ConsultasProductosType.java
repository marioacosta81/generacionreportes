package co.com.davivienda.consultasproducto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ConsultasProductosType",
        propOrder = {"request"}
)
public class ConsultasProductosType {

    @XmlElement(
            name = "Request",
            required = true
    )
    protected RequestType request;

    public RequestType getRequest() {
        return this.request;
    }

    public void setRequest(RequestType value) {
        this.request = value;
    }
}
