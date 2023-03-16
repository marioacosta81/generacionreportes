package org.jnbis.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jnbis.internal.record.BaseImageRecord;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacialAndSmtImage
        extends BaseImageRecord {

    @JsonProperty("image_type")
    private String imageType;
    @JsonProperty("source_agency")
    private String sourceAgency;
    @JsonProperty("photo_date")
    private String photoDate;
    @JsonProperty("scale_units")
    private String scaleUnits;
    @JsonProperty("horizontal_pixel_scale")
    private String horizontalPixelScale;
    @JsonProperty("vertical_pixel_scale")
    private String verticalPixelScale;
    @JsonProperty("color_space")
    private String colorSpace;
    @JsonProperty("subject_acquisition_profile")
    private String subjectAcquisitionProfile;
    @JsonProperty("scanned_horizontal_pixel_scale")
    private String scannedHorizontalPixelScale;
    @JsonProperty("scanned_vertical_pixel_scale")
    private String scannedVerticalPixelScale;
    @JsonProperty("subject_pose")
    private String subjectPose;
    @JsonProperty("pose_offset_angle")
    private String poseOffsetAngle;
    @JsonProperty("photo_description")
    private String photoDescription;
    @JsonProperty("photo_acquisition_source")
    private String photoAcquisitionSource;
    @JsonProperty("subject_quality_score")
    private String subjectQualityScore;
    @JsonProperty("subject_pose_angles")
    private String subjectPoseAngles;
    @JsonProperty("subject_facial_description")
    private String subjectFacialDescription;
    @JsonProperty("subject_eye_color")
    private String subjectEyeColor;
    @JsonProperty("subject_hair_color")
    private String subjectHairColor;
    @JsonProperty("facial_feature_points")
    private String facialFeaturePoints;
    @JsonProperty("device_monitoring_mode")
    private String deviceMonitoringMode;
    @JsonProperty("ncic_designation_code")
    private String ncicDesignationCode;
    @JsonProperty("scar_mark_tattoo_size")
    private String scarMarkTattooSize;
    @JsonProperty("smt_descriptors")
    private String smtDescriptors;
    @JsonProperty("colors_present")
    private String colorsPresent;

    public String getImageType() {
        return this.imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getSourceAgency() {
        return this.sourceAgency;
    }

    public void setSourceAgency(String sourceAgency) {
        this.sourceAgency = sourceAgency;
    }

    public String getPhotoDate() {
        return this.photoDate;
    }

    public void setPhotoDate(String photoDate) {
        this.photoDate = photoDate;
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

    public String getColorSpace() {
        return this.colorSpace;
    }

    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace;
    }

    public String getSubjectAcquisitionProfile() {
        return this.subjectAcquisitionProfile;
    }

    public void setSubjectAcquisitionProfile(String subjectAcquisitionProfile) {
        this.subjectAcquisitionProfile = subjectAcquisitionProfile;
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

    public String getSubjectPose() {
        return this.subjectPose;
    }

    public void setSubjectPose(String subjectPose) {
        this.subjectPose = subjectPose;
    }

    public String getPoseOffsetAngle() {
        return this.poseOffsetAngle;
    }

    public void setPoseOffsetAngle(String poseOffsetAngle) {
        this.poseOffsetAngle = poseOffsetAngle;
    }

    public String getPhotoDescription() {
        return this.photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getPhotoAcquisitionSource() {
        return this.photoAcquisitionSource;
    }

    public void setPhotoAcquisitionSource(String photoAcquisitionSource) {
        this.photoAcquisitionSource = photoAcquisitionSource;
    }

    public String getSubjectQualityScore() {
        return this.subjectQualityScore;
    }

    public void setSubjectQualityScore(String subjectQualityScore) {
        this.subjectQualityScore = subjectQualityScore;
    }

    public String getSubjectPoseAngles() {
        return this.subjectPoseAngles;
    }

    public void setSubjectPoseAngles(String subjectPoseAngles) {
        this.subjectPoseAngles = subjectPoseAngles;
    }

    public String getSubjectFacialDescription() {
        return this.subjectFacialDescription;
    }

    public void setSubjectFacialDescription(String subjectFacialDescription) {
        this.subjectFacialDescription = subjectFacialDescription;
    }

    public String getSubjectEyeColor() {
        return this.subjectEyeColor;
    }

    public void setSubjectEyeColor(String subjectEyeColor) {
        this.subjectEyeColor = subjectEyeColor;
    }

    public String getSubjectHairColor() {
        return this.subjectHairColor;
    }

    public void setSubjectHairColor(String subjectHairColor) {
        this.subjectHairColor = subjectHairColor;
    }

    public String getFacialFeaturePoints() {
        return this.facialFeaturePoints;
    }

    public void setFacialFeaturePoints(String facialFeaturePoints) {
        this.facialFeaturePoints = facialFeaturePoints;
    }

    public String getDeviceMonitoringMode() {
        return this.deviceMonitoringMode;
    }

    public void setDeviceMonitoringMode(String deviceMonitoringMode) {
        this.deviceMonitoringMode = deviceMonitoringMode;
    }

    public String getNcicDesignationCode() {
        return this.ncicDesignationCode;
    }

    public void setNcicDesignationCode(String ncicDesignationCode) {
        this.ncicDesignationCode = ncicDesignationCode;
    }

    public String getScarMarkTattooSize() {
        return this.scarMarkTattooSize;
    }

    public void setScarMarkTattooSize(String scarMarkTattooSize) {
        this.scarMarkTattooSize = scarMarkTattooSize;
    }

    public String getSmtDescriptors() {
        return this.smtDescriptors;
    }

    public void setSmtDescriptors(String smtDescriptors) {
        this.smtDescriptors = smtDescriptors;
    }

    public String getColorsPresent() {
        return this.colorsPresent;
    }

    public void setColorsPresent(String colorsPresent) {
        this.colorsPresent = colorsPresent;
    }
}
