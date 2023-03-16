package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

public class VariableResolutionPalmprint
        extends BaseVariableResolutionImageRecord {

    private String palmprintPosition;
    private String palmprintQualityMetric;

    public String getPalmprintPosition() {
        return this.palmprintPosition;
    }

    public void setPalmprintPosition(String palmprintPosition) {
        this.palmprintPosition = palmprintPosition;
    }

    public String getPalmprintQualityMetric() {
        return this.palmprintQualityMetric;
    }

    public void setPalmprintQualityMetric(String palmprintQualityMetric) {
        this.palmprintQualityMetric = palmprintQualityMetric;
    }
}
