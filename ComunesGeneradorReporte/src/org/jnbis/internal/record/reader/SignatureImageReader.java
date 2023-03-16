package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.SignatureImage;

public class SignatureImageReader
        extends RecordReader {

    public SignatureImage read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T8::NULL pointer to T8 record");
        }

        SignatureImage signatureImage = new SignatureImage();

        Integer length = Integer.valueOf((int) readInt(token));

        int dataSize = length.intValue() - 12;

        if (token.pos + dataSize + 11 > token.buffer.length) {
            dataSize += token.buffer.length - token.pos - 12;
        }

        byte[] data = new byte[dataSize];
        System.arraycopy(token.buffer, token.pos + 12, data, 0, data.length + 12 - 12);

        token.pos += length.intValue();
        signatureImage.setImageData(data);
        signatureImage.setLogicalRecordLength(length.toString());

        return signatureImage;
    }
}
