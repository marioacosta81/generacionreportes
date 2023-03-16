package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.MinutiaeData;

public class MinutiaeDataReader
        extends RecordReader {

    public MinutiaeData read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T9::NULL pointer to T9 record");
        }

        MinutiaeData minutiaeData = new MinutiaeData();

        int start = token.pos;

        NistHelper.Tag tag = getTagInfo(token);
        if (tag.field != 1) {
            throw new RuntimeException("T9::Invalid Record type = " + tag.type);
        }

        int length = Integer.parseInt(nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false));

        token.pos++;

        tag = getTagInfo(token);

        byte[] data = new byte[length - token.pos - start];
        System.arraycopy(token.buffer, token.pos, data, 0, data.length);
        token.pos += data.length;

        return minutiaeData;
    }

    protected NistHelper.Tag getTagInfo(NistHelper.Token token) {
        String type = nextWord(token, NistHelper.TAG_SEP_DOT, 2, false);
        token.pos++;
        String field = nextWord(token, NistHelper.TAG_SEP_COLN, 10, false);
        token.pos++;

        return new NistHelper.Tag(Integer.parseInt(type), Integer.parseInt(field));
    }
}
