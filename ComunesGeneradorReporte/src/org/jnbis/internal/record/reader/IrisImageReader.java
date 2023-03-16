package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.IrisImage;

public class IrisImageReader
        extends RecordReader {

    public IrisImage read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T17::NULL pointer to T17 record");
        }

        IrisImage image = new IrisImage();

        int start = token.pos;

        NistHelper.Tag tag = getTagInfo(token);
        if (tag.field != 1) {
            throw new RuntimeException("T17::Invalid Record type = " + tag.type);
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
                    image.setFeatureIdentifier(word);

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
                    image.setColorSpace(word);

                case 14:
                    image.setRotationAngleOfEye(word);

                case 15:
                    image.setRotationUncertainty(word);

                case 16:
                    image.setImagePropertyCode(word);

                case 17:
                    image.setDeviceUniqueIdentifier(word);

                case 18:
                    image.setGlobalUniqueIdentifier(word);

                case 19:
                    image.setMakeModelSerialNumber(word);

                case 20:
                    image.setEyeColor(word);

                case 21:
                    image.setComment(word);

                case 22:
                    image.setScannedHorizontalPixelScale(word);

                case 23:
                    image.setScannedVerticalPixelScale(word);

                case 24:
                    image.setImageQualityScore(word);

                case 25:
                    image.setAcquisitionLightingSpectrum(word);

                case 26:
                    image.setIrisDiameter(word);

                case 30:
                    image.setDeviceMonitoringMode(word);
            }

        }
        return image;
    }
}
