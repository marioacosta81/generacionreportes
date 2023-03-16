package org.jnbis.record;

import org.jnbis.internal.record.BaseImageRecord;

public class MinutiaeData
        extends BaseImageRecord {

    private String impressionType;
    private String minutiaeFormat;
    private String originatingFingerprintReadingSystem;
    private String fingerPosition;
    private String fingerprintPatternClassification;
    private String corePosition;
    private String deltaPosition;
    private String numberOfMinutiae;

    public String getImpressionType() {
        return this.impressionType;
    }

    public void setImpressionType(String impressionType) {
        this.impressionType = impressionType;
    }

    public String getMinutiaeFormat() {
        return this.minutiaeFormat;
    }

    public void setMinutiaeFormat(String minutiaeFormat) {
        this.minutiaeFormat = minutiaeFormat;
    }

    public String getOriginatingFingerprintReadingSystem() {
        return this.originatingFingerprintReadingSystem;
    }

    public void setOriginatingFingerprintReadingSystem(String originatingFingerprintReadingSystem) {
        this.originatingFingerprintReadingSystem = originatingFingerprintReadingSystem;
    }

    public String getFingerPosition() {
        return this.fingerPosition;
    }

    public void setFingerPosition(String fingerPosition) {
        this.fingerPosition = fingerPosition;
    }

    public String getFingerprintPatternClassification() {
        return this.fingerprintPatternClassification;
    }

    public void setFingerprintPatternClassification(String fingerprintPatternClassification) {
        this.fingerprintPatternClassification = fingerprintPatternClassification;
    }

    public String getCorePosition() {
        return this.corePosition;
    }

    public void setCorePosition(String corePosition) {
        this.corePosition = corePosition;
    }

    public String getDeltaPosition() {
        return this.deltaPosition;
    }

    public void setDeltaPosition(String deltaPosition) {
        this.deltaPosition = deltaPosition;
    }

    public String getNumberOfMinutiae() {
        return this.numberOfMinutiae;
    }

    public void setNumberOfMinutiae(String numberOfMinutiae) {
        this.numberOfMinutiae = numberOfMinutiae;
    }
}
