package co.com.davivienda.consultasproducto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ResponseType",
        propOrder = {"dataHeader", "data"}
)
public class ResponseType {

    @XmlElement(
            name = "DataHeader",
            required = true
    )
    protected DataHeaderRespType dataHeader;
    @XmlElement(
            name = "Data"
    )
    protected DataRespType data;

    public DataHeaderRespType getDataHeader() {
        return this.dataHeader;
    }

    public void setDataHeader(DataHeaderRespType value) {
        this.dataHeader = value;
    }

    public DataRespType getData() {
        return this.data;
    }

    public void setData(DataRespType value) {
        this.data = value;
    }
}
