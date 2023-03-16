package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.FacialAndSmtImage;

public class FacialAndSmtImageReader
        extends RecordReader {

    public FacialAndSmtImage read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T10::NULL pointer to T10 record");
        }

        FacialAndSmtImage facialRecord = new FacialAndSmtImage();

        int start = token.pos;

        NistHelper.Tag tag = getTagInfo(token);
        if (tag.field != 1) {
            throw new RuntimeException("T10::Invalid Record type = " + tag.type);
        }

        Integer length = Integer.valueOf(Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false)));
        facialRecord.setLogicalRecordLength(length.toString());

        while (true) {
            token.pos++;

            tag = getTagInfo(token);

            if (tag.field == 999) {
                byte[] data = new byte[length.intValue() - token.pos - start];
                System.arraycopy(token.buffer, token.pos, data, 0, data.length);
                token.pos += data.length;
                facialRecord.setImageData(data);

                break;
            }
            String word = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);
            switch (tag.field) {
                case 1:
                    facialRecord.setLogicalRecordLength(word);

                case 2:
                    facialRecord.setImageDesignationCharacter(word);

                case 3:
                    facialRecord.setImageType(word);

                case 4:
                    facialRecord.setSourceAgency(word);

                case 5:
                    facialRecord.setPhotoDate(word);

                case 6:
                    facialRecord.setHorizontalLineLength(word);

                case 7:
                    facialRecord.setVerticalLineLength(word);

                case 8:
                    facialRecord.setScaleUnits(word);

                case 9:
                    facialRecord.setHorizontalPixelScale(word);

                case 10:
                    facialRecord.setVerticalPixelScale(word);

                case 11:
                    facialRecord.setCompressionAlgorithm(word);

                case 12:
                    facialRecord.setColorSpace(word);

                case 13:
                    facialRecord.setSubjectAcquisitionProfile(word);

                case 16:
                    facialRecord.setScannedHorizontalPixelScale(word);

                case 17:
                    facialRecord.setScannedVerticalPixelScale(word);

                case 20:
                    facialRecord.setSubjectPose(word);

                case 21:
                    facialRecord.setPoseOffsetAngle(word);

                case 22:
                    facialRecord.setPhotoDescription(word);

                case 23:
                    facialRecord.setPhotoAcquisitionSource(word);

                case 24:
                    facialRecord.setSubjectQualityScore(word);

                case 25:
                    facialRecord.setSubjectPoseAngles(word);

                case 26:
                    facialRecord.setSubjectFacialDescription(word);

                case 27:
                    facialRecord.setSubjectEyeColor(word);

                case 28:
                    facialRecord.setSubjectHairColor(word);

                case 29:
                    facialRecord.setFacialFeaturePoints(word);

                case 30:
                    facialRecord.setDeviceMonitoringMode(word);

                case 40:
                    facialRecord.setNcicDesignationCode(word);

                case 41:
                    facialRecord.setScarMarkTattooSize(word);

                case 42:
                    facialRecord.setSmtDescriptors(word);

                case 43:
                    facialRecord.setColorsPresent(word);
            }

        }
        return facialRecord;
    }
}
