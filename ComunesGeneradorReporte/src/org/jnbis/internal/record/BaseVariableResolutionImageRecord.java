package org.jnbis.internal.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseVariableResolutionImageRecord
        extends BaseImageRecord {

    @JsonProperty("impression_type")
    private String impressionType;
    @JsonProperty("source_agency")
    private String sourceAgency;
    @JsonProperty("capture_date")
    private String captureDate;
    @JsonProperty("scale_units")
    private String scaleUnits;
    @JsonProperty("horizontal_pixel_scale")
    private String horizontalPixelScale;
    @JsonProperty("vertical_pixel_scale")
    private String verticalPixelScale;
    @JsonProperty("bits_per_pixel")
    private String bitsPerPixel;
    @JsonProperty("scanned_horizontal_pixel_scale")
    private String scannedHorizontalPixelScale;
    @JsonProperty("scanned_vertical_pixel_scale")
    private String scannedVerticalPixelScale;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("device_monitoring_mode")
    private String deviceMonitoringMode;

    public String getImpressionType() {
        return this.impressionType;
    }

    public void setImpressionType(String impressionType) {
        this.impressionType = impressionType;
    }

    public String getSourceAgency() {
        return this.sourceAgency;
    }

    public void setSourceAgency(String sourceAgency) {
        this.sourceAgency = sourceAgency;
    }

    public String getCaptureDate() {
        return this.captureDate;
    }

    public void setCaptureDate(String captureDate) {
        this.captureDate = captureDate;
    }

    public String getScaleUnits() {
        return this.scaleUnits;
    }

    public void setScaleUnits(String scaleUnits) {
        this.scaleUnits = scaleUnits;
    }

    public String getHorizontalPixelScale() {
        return this.horizontalPixelScale;
    }

    public void setHorizontalPixelScale(String horizontalPixelScale) {
        this.horizontalPixelScale = horizontalPixelScale;
    }

    public String getVerticalPixelScale() {
        return this.verticalPixelScale;
    }

    public void setVerticalPixelScale(String verticalPixelScale) {
        this.verticalPixelScale = verticalPixelScale;
    }

    public String getBitsPerPixel() {
        return this.bitsPerPixel;
    }

    public void setBitsPerPixel(String bitsPerPixel) {
        this.bitsPerPixel = bitsPerPixel;
    }

    public String getScannedHorizontalPixelScale() {
        return this.scannedHorizontalPixelScale;
    }

    public void setScannedHorizontalPixelScale(String scannedHorizontalPixelScale) {
        this.scannedHorizontalPixelScale = scannedHorizontalPixelScale;
    }

    public String getScannedVerticalPixelScale() {
        return this.scannedVerticalPixelScale;
    }

    public void setScannedVerticalPixelScale(String scannedVerticalPixelScale) {
        this.scannedVerticalPixelScale = scannedVerticalPixelScale;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDeviceMonitoringMode() {
        return this.deviceMonitoringMode;
    }

    public void setDeviceMonitoringMode(String deviceMonitoringMode) {
        this.deviceMonitoringMode = deviceMonitoringMode;
    }
}
