package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.VariableResolutionPalmprint;

public class VariableResolutionPalmprintReader
        extends RecordReader {

    public VariableResolutionPalmprint read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T14::NULL pointer to T14 record");
        }

        VariableResolutionPalmprint palmprint = new VariableResolutionPalmprint();

        int start = token.pos;

        NistHelper.Tag tag = getTagInfo(token);
        if (tag.field != 1) {
            throw new RuntimeException("T14::Invalid Record type = " + tag.type);
        }

        Integer length = Integer.valueOf(Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false)));
        palmprint.setLogicalRecordLength(length.toString());

        while (true) {
            token.pos++;

            tag = getTagInfo(token);
            if (tag.field == 999) {
                byte[] data = new byte[length.intValue() - token.pos - start];
                System.arraycopy(token.buffer, token.pos, data, 0, data.length);
                token.pos += data.length;
                palmprint.setImageData(data);

                break;
            }
            String word = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            switch (tag.field) {
                case 1:
                    palmprint.setLogicalRecordLength(word);

                case 2:
                    palmprint.setImageDesignationCharacter(word);

                case 3:
                    palmprint.setImpressionType(word);

                case 4:
                    palmprint.setSourceAgency(word);

                case 5:
                    palmprint.setCaptureDate(word);

                case 6:
                    palmprint.setHorizontalLineLength(word);

                case 7:
                    palmprint.setVerticalLineLength(word);

                case 8:
                    palmprint.setScaleUnits(word);

                case 9:
                    palmprint.setHorizontalPixelScale(word);

                case 10:
                    palmprint.setVerticalPixelScale(word);

                case 11:
                    palmprint.setCompressionAlgorithm(word);

                case 12:
                    palmprint.setBitsPerPixel(word);

                case 13:
                    palmprint.setPalmprintPosition(word);

                case 16:
                    palmprint.setScannedHorizontalPixelScale(word);

                case 17:
                    palmprint.setScannedVerticalPixelScale(word);

                case 20:
                    palmprint.setComment(word);

                case 24:
                    palmprint.setPalmprintQualityMetric(word);

                case 30:
                    palmprint.setDeviceMonitoringMode(word);
            }

        }
        return palmprint;
    }
}
