package org.jnbis.internal.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseRecord
        implements Serializable {

    @JsonProperty("logical_record_length")
    private String logicalRecordLength;

    public String getLogicalRecordLength() {
        return this.logicalRecordLength;
    }

    public void setLogicalRecordLength(String logicalRecordLength) {
        this.logicalRecordLength = logicalRecordLength;
    }
}
