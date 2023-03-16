package co.com.davivienda.consultacertificacionPreventaContragarantia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ConsultaCertificadoProductoResponseType",
        propOrder = {"dataHeader", "data"}
)
public class ConsultaCertificadoProductoResponseType {

    @XmlElement(
            name = "DataHeader",
            required = true
    )
    protected DataHeaderResType dataHeader;
    @XmlElement(
            name = "Data"
    )
    protected DataResType data;

    public DataHeaderResType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderResType value) {
        this.dataHeader = value;
    }

    public DataResType getData() {
        return this.data;
    }

    public void setData(DataResType value) {
        this.data = value;
    }
}
