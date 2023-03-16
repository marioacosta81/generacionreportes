package org.jnbis.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jnbis.internal.record.BaseRecord;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionInformation
        extends BaseRecord {

    @JsonProperty("version")
    private String version;
    @JsonProperty("file_content")
    private String fileContent;
    @JsonProperty("type_of_transaction")
    private String typeOfTransaction;
    @JsonProperty("date")
    private String date;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("destination_agency_id")
    private String destinationAgencyId;
    @JsonProperty("originating_agency_id")
    private String originatingAgencyId;
    @JsonProperty("control_number")
    private String controlNumber;
    @JsonProperty("control_reference_number")
    private String controlReferenceNumber;
    @JsonProperty("native_scanning_resolution")
    private String nativeScanningResolution;
    @JsonProperty("nominal_transmitting_resolution")
    private String nominalTransmittingResolution;
    @JsonProperty("domain_name")
    private String domainName;
    @JsonProperty("greenwich_mean_time")
    private String greenwichMeanTime;
    @JsonProperty("directory_of_charsets")
    private String directoryOfCharsets;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFileContent() {
        return this.fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getTypeOfTransaction() {
        return this.typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDestinationAgencyId() {
        return this.destinationAgencyId;
    }

    public void setDestinationAgencyId(String destinationAgencyId) {
        this.destinationAgencyId = destinationAgencyId;
    }

    public String getOriginatingAgencyId() {
        return this.originatingAgencyId;
    }

    public void setOriginatingAgencyId(String originatingAgencyId) {
        this.originatingAgencyId = originatingAgencyId;
    }

    public String getControlNumber() {
        return this.controlNumber;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getControlReferenceNumber() {
        return this.controlReferenceNumber;
    }

    public void setControlReferenceNumber(String controlReferenceNumber) {
        this.controlReferenceNumber = controlReferenceNumber;
    }

    public String getNativeScanningResolution() {
        return this.nativeScanningResolution;
    }

    public void setNativeScanningResolution(String nativeScanningResolution) {
        this.nativeScanningResolution = nativeScanningResolution;
    }

    public String getNominalTransmittingResolution() {
        return this.nominalTransmittingResolution;
    }

    public void setNominalTransmittingResolution(String nominalTransmittingResolution) {
        this.nominalTransmittingResolution = nominalTransmittingResolution;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getGreenwichMeanTime() {
        return this.greenwichMeanTime;
    }

    public void setGreenwichMeanTime(String greenwichMeanTime) {
        this.greenwichMeanTime = greenwichMeanTime;
    }

    public String getDirectoryOfCharsets() {
        return this.directoryOfCharsets;
    }

    public void setDirectoryOfCharsets(String directoryOfCharsets) {
        this.directoryOfCharsets = directoryOfCharsets;
    }
}
