package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.VariableResolutionLatentImage;

public class VariableResolutionLatentImageReader
        extends RecordReader {

    public VariableResolutionLatentImage read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T13::NULL pointer to T13 record");
        }

        VariableResolutionLatentImage image = new VariableResolutionLatentImage();

        int start = token.pos;

        NistHelper.Tag tag = getTagInfo(token);
        if (tag.field != 1) {
            throw new RuntimeException("T13::Invalid Record type = " + tag.type);
        }

        Integer length = Integer.valueOf(Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false)));
        image.setLogicalRecordLength(length.toString());

        while (true) {
            token.pos++;

            tag = getTagInfo(token);

            if (tag.field == 999) {
                byte[] data = new byte[length.intValue() - token.pos - start];
                System.arraycopy(token.buffer, token.pos, data, 0, data.length);
                token.pos += data.length;
                image.setImageData(data);

                break;
            }
            String word = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            switch (tag.field) {
                case 1:
                    image.setLogicalRecordLength(word);

                case 2:
                    image.setImageDesignationCharacter(word);

                case 3:
                    image.setImpressionType(word);

                case 4:
                    image.setSourceAgency(word);

                case 5:
                    image.setCaptureDate(word);

                case 6:
                    image.setHorizontalLineLength(word);

                case 7:
                    image.setVerticalLineLength(word);

                case 8:
                    image.setScaleUnits(word);

                case 9:
                    image.setHorizontalPixelScale(word);

                case 10:
                    image.setVerticalPixelScale(word);

                case 11:
                    image.setCompressionAlgorithm(word);

                case 12:
                    image.setBitsPerPixel(word);

                case 13:
                    image.setFingerPalmPosition(word);

                case 14:
                    image.setSearchPositionDescriptors(word);

                case 15:
                    image.setPrintPositionCoordinates(word);

                case 16:
                    image.setScannedHorizontalPixelScale(word);

                case 17:
                    image.setScannedVerticalPixelScale(word);

                case 20:
                    image.setComment(word);

                case 24:
                    image.setLatentQualityMetric(word);
            }

        }
        return image;
    }
}
