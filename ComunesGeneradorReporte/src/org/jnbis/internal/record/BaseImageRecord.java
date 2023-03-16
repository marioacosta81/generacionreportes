package org.jnbis.internal.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseImageRecord
        extends BaseRecord {

    @JsonProperty("image_designation_character")
    private String imageDesignationCharacter;
    @JsonProperty("horizontal_line_length")
    private String horizontalLineLength;
    @JsonProperty("vertical_line_length")
    private String verticalLineLength;
    @JsonProperty("compression_algorithm")
    private String compressionAlgorithm;
    @JsonProperty("image_data")
    private byte[] imageData;

    public String getImageDesignationCharacter() {
        return this.imageDesignationCharacter;
    }

    public void setImageDesignationCharacter(String imageDesignationCharacter) {
        this.imageDesignationCharacter = imageDesignationCharacter;
    }

    public String getHorizontalLineLength() {
        return this.horizontalLineLength;
    }

    public void setHorizontalLineLength(String horizontalLineLength) {
        this.horizontalLineLength = horizontalLineLength;
    }

    public String getVerticalLineLength() {
        return this.verticalLineLength;
    }

    public void setVerticalLineLength(String verticalLineLength) {
        this.verticalLineLength = verticalLineLength;
    }

    public String getCompressionAlgorithm() {
        return this.compressionAlgorithm;
    }

    public void setCompressionAlgorithm(String compressionAlgorithm) {
        this.compressionAlgorithm = compressionAlgorithm;
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
