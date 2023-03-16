package org.jnbis.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jnbis.internal.record.BaseGrayscaleFingerprintRecord;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HighResolutionGrayscaleFingerprint extends BaseGrayscaleFingerprintRecord {
}
