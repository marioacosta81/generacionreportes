package org.jnbis.record;

import org.jnbis.internal.record.BaseVariableResolutionImageRecord;

public class IrisImage
        extends BaseVariableResolutionImageRecord {

    private String featureIdentifier;
    private String colorSpace;
    private String rotationAngleOfEye;
    private String rotationUncertainty;
    private String imagePropertyCode;
    private String deviceUniqueIdentifier;
    private String globalUniqueIdentifier;
    private String makeModelSerialNumber;
    private String eyeColor;
    private String imageQualityScore;
    private String acquisitionLightingSpectrum;
    private String irisDiameter;

    public String getFeatureIdentifier() {
        return this.featureIdentifier;
    }

    public void setFeatureIdentifier(String featureIdentifier) {
        this.featureIdentifier = featureIdentifier;
    }

    public String getColorSpace() {
        return this.colorSpace;
    }

    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace;
    }

    public String getRotationAngleOfEye() {
        return this.rotationAngleOfEye;
    }

    public void setRotationAngleOfEye(String rotationAngleOfEye) {
        this.rotationAngleOfEye = rotationAngleOfEye;
    }

    public String getRotationUncertainty() {
        return this.rotationUncertainty;
    }

    public void setRotationUncertainty(String rotationUncertainty) {
        this.rotationUncertainty = rotationUncertainty;
    }

    public String getImagePropertyCode() {
        return this.imagePropertyCode;
    }

    public void setImagePropertyCode(String imagePropertyCode) {
        this.imagePropertyCode = imagePropertyCode;
    }

    public String getDeviceUniqueIdentifier() {
        return this.deviceUniqueIdentifier;
    }

    public void setDeviceUniqueIdentifier(String deviceUniqueIdentifier) {
        this.deviceUniqueIdentifier = deviceUniqueIdentifier;
    }

    public String getGlobalUniqueIdentifier() {
        return this.globalUniqueIdentifier;
    }

    public void setGlobalUniqueIdentifier(String globalUniqueIdentifier) {
        this.globalUniqueIdentifier = globalUniqueIdentifier;
    }

    public String getMakeModelSerialNumber() {
        return this.makeModelSerialNumber;
    }

    public void setMakeModelSerialNumber(String makeModelSerialNumber) {
        this.makeModelSerialNumber = makeModelSerialNumber;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getImageQualityScore() {
        return this.imageQualityScore;
    }

    public void setImageQualityScore(String imageQualityScore) {
        this.imageQualityScore = imageQualityScore;
    }

    public String getAcquisitionLightingSpectrum() {
        return this.acquisitionLightingSpectrum;
    }

    public void setAcquisitionLightingSpectrum(String acquisitionLightingSpectrum) {
        this.acquisitionLightingSpectrum = acquisitionLightingSpectrum;
    }

    public String getIrisDiameter() {
        return this.irisDiameter;
    }

    public void setIrisDiameter(String irisDiameter) {
        this.irisDiameter = irisDiameter;
    }
}
