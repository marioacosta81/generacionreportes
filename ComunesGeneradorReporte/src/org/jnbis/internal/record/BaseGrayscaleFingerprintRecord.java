package org.jnbis.internal.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseGrayscaleFingerprintRecord
        extends BaseImageRecord {

    @JsonProperty("impression_type")
    private String impressionType;
    @JsonProperty("finger_position")
    private String fingerPosition;
    @JsonProperty("image_scanning_resolution")
    private String imageScanningResolution;

    public String getImpressionType() {
        return this.impressionType;
    }

    public void setImpressionType(String impressionType) {
        this.impressionType = impressionType;
    }

    public String getFingerPosition() {
        return this.fingerPosition;
    }

    public void setFingerPosition(String fingerPosition) {
        this.fingerPosition = fingerPosition;
    }

    public String getImageScanningResolution() {
        return this.imageScanningResolution;
    }

    public void setImageScanningResolution(String imageScanningResolution) {
        this.imageScanningResolution = imageScanningResolution;
    }
}
