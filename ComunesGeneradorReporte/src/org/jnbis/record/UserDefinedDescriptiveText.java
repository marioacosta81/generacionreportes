package org.jnbis.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import org.jnbis.internal.record.BaseRecord;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDefinedDescriptiveText
        extends BaseRecord {

    @JsonProperty("user_defined_fields")
    private Map<Integer, String> userDefinedFields;

    public Map<Integer, String> getUserDefinedFields() {
        return this.userDefinedFields;
    }

    public void setUserDefinedFields(Map<Integer, String> userDefinedFields) {
        this.userDefinedFields = userDefinedFields;
    }

    public void addUserDefinedField(Integer key, String value) {
        if (this.userDefinedFields == null) {
            this.userDefinedFields = new HashMap<Integer, String>();
        }
        this.userDefinedFields.put(key, value);
    }
}
