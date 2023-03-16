package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.UserDefinedImage;

public class UserDefinedImageReader
        extends RecordReader {

    public UserDefinedImage read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T7::NULL pointer to T7 record");
        }

        UserDefinedImage userDefinedImage = new UserDefinedImage();

        Integer length = Integer.valueOf((int) readInt(token));

        int dataSize = length.intValue() - 5;

        if (token.pos + dataSize + 4 > token.buffer.length) {
            dataSize += token.buffer.length - token.pos - 5;
        }

        byte[] data = new byte[dataSize];
        System.arraycopy(token.buffer, token.pos + 5, data, 0, data.length + 5 - 5);

        token.pos += length.intValue();

        userDefinedImage.setImageData(data);
        userDefinedImage.setLogicalRecordLength(length.toString());

        return userDefinedImage;
    }
}
