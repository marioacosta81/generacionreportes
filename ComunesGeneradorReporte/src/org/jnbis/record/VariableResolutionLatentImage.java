package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

public class VariableResolutionLatentImage
        extends BaseVariableResolutionImageRecord {

    private String fingerPalmPosition;
    private String searchPositionDescriptors;
    private String printPositionCoordinates;
    private String latentQualityMetric;

    public String getFingerPalmPosition() {
        return this.fingerPalmPosition;
    }

    public void setFingerPalmPosition(String fingerPalmPosition) {
        this.fingerPalmPosition = fingerPalmPosition;
    }

    public String getSearchPositionDescriptors() {
        return this.searchPositionDescriptors;
    }

    public void setSearchPositionDescriptors(String searchPositionDescriptors) {
        this.searchPositionDescriptors = searchPositionDescriptors;
    }

    public String getPrintPositionCoordinates() {
        return this.printPositionCoordinates;
    }

    public void setPrintPositionCoordinates(String printPositionCoordinates) {
        this.printPositionCoordinates = printPositionCoordinates;
    }

    public String getLatentQualityMetric() {
        return this.latentQualityMetric;
    }

    public void setLatentQualityMetric(String latentQualityMetric) {
        this.latentQualityMetric = latentQualityMetric;
    }
}
