package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.VariableResolutionFingerprint;

public class VariableResolutionFingerprintReader
        extends RecordReader {

    public VariableResolutionFingerprint read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T14::NULL pointer to T14 record");
        }

        VariableResolutionFingerprint fingerprint = new VariableResolutionFingerprint();

        int start = token.pos;

        NistHelper.Tag tag = getTagInfo(token);
        if (tag.field != 1) {
            throw new RuntimeException("T14::Invalid Record type = " + tag.type);
        }

        Integer length = Integer.valueOf(Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false)));
        fingerprint.setLogicalRecordLength(length.toString());

        while (true) {
            token.pos++;

            tag = getTagInfo(token);

            if (tag.field == 999) {
                byte[] data = new byte[length.intValue() - token.pos - start];
                System.arraycopy(token.buffer, token.pos, data, 0, data.length);
                token.pos += data.length;
                fingerprint.setImageData(data);

                break;
            }
            String word = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            switch (tag.field) {
                case 1:
                    fingerprint.setLogicalRecordLength(word);

                case 2:
                    fingerprint.setImageDesignationCharacter(word);

                case 3:
                    fingerprint.setImpressionType(word);

                case 4:
                    fingerprint.setSourceAgency(word);

                case 5:
                    fingerprint.setCaptureDate(word);

                case 6:
                    fingerprint.setHorizontalLineLength(word);

                case 7:
                    fingerprint.setVerticalLineLength(word);

                case 8:
                    fingerprint.setScaleUnits(word);

                case 9:
                    fingerprint.setHorizontalPixelScale(word);

                case 10:
                    fingerprint.setVerticalPixelScale(word);

                case 11:
                    fingerprint.setCompressionAlgorithm(word);

                case 12:
                    fingerprint.setBitsPerPixel(word);

                case 13:
                    fingerprint.setFingerPosition(word);

                case 14:
                    fingerprint.setPrintPositionDescriptors(word);

                case 15:
                    fingerprint.setPrintPositionCoordinates(word);

                case 16:
                    fingerprint.setScannedHorizontalPixelScale(word);

                case 17:
                    fingerprint.setScannedVerticalPixelScale(word);

                case 18:
                    fingerprint.setAmputatedOrBandaged(word);

                case 20:
                    fingerprint.setComment(word);

                case 21:
                    fingerprint.setFingerprintSegmentationPosition(word);

                case 22:
                    fingerprint.setNistQualityMetric(word);

                case 23:
                    fingerprint.setSegmentationQualityMetric(word);

                case 24:
                    fingerprint.setFingerprintQualityMetric(word);

                case 25:
                    fingerprint.setAlternateFingerSegmentPosition(word);

                case 30:
                    fingerprint.setDeviceMonitoringMode(word);
            }

        }
        return fingerprint;
    }
}
