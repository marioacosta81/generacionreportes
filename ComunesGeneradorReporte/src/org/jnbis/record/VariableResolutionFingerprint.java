package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

public class VariableResolutionFingerprint
        extends BaseVariableResolutionImageRecord {

    private String fingerPosition;
    private String printPositionDescriptors;
    private String printPositionCoordinates;
    private String amputatedOrBandaged;
    private String fingerprintSegmentationPosition;
    private String nistQualityMetric;
    private String segmentationQualityMetric;
    private String fingerprintQualityMetric;
    private String alternateFingerSegmentPosition;

    public String getFingerPosition() {
        return this.fingerPosition;
    }

    public void setFingerPosition(String fingerPosition) {
        this.fingerPosition = fingerPosition;
    }

    public String getPrintPositionDescriptors() {
        return this.printPositionDescriptors;
    }

    public void setPrintPositionDescriptors(String printPositionDescriptors) {
        this.printPositionDescriptors = printPositionDescriptors;
    }

    public String getPrintPositionCoordinates() {
        return this.printPositionCoordinates;
    }

    public void setPrintPositionCoordinates(String printPositionCoordinates) {
        this.printPositionCoordinates = printPositionCoordinates;
    }

    public String getAmputatedOrBandaged() {
        return this.amputatedOrBandaged;
    }

    public void setAmputatedOrBandaged(String amputatedOrBandaged) {
        this.amputatedOrBandaged = amputatedOrBandaged;
    }

    public String getFingerprintSegmentationPosition() {
        return this.fingerprintSegmentationPosition;
    }

    public void setFingerprintSegmentationPosition(String fingerprintSegmentationPosition) {
        this.fingerprintSegmentationPosition = fingerprintSegmentationPosition;
    }

    public String getNistQualityMetric() {
        return this.nistQualityMetric;
    }

    public void setNistQualityMetric(String nistQualityMetric) {
        this.nistQualityMetric = nistQualityMetric;
    }

    public String getSegmentationQualityMetric() {
        return this.segmentationQualityMetric;
    }

    public void setSegmentationQualityMetric(String segmentationQualityMetric) {
        this.segmentationQualityMetric = segmentationQualityMetric;
    }

    public String getFingerprintQualityMetric() {
        return this.fingerprintQualityMetric;
    }

    public void setFingerprintQualityMetric(String fingerprintQualityMetric) {
        this.fingerprintQualityMetric = fingerprintQualityMetric;
    }

    public String getAlternateFingerSegmentPosition() {
        return this.alternateFingerSegmentPosition;
    }

    public void setAlternateFingerSegmentPosition(String alternateFingerSegmentPosition) {
        this.alternateFingerSegmentPosition = alternateFingerSegmentPosition;
    }
}
