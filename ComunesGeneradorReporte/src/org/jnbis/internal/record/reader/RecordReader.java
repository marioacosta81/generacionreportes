package org.jnbis.internal.record.reader;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;

public abstract class RecordReader {

    public abstract BaseRecord read(NistHelper.Token paramToken);

    protected NistHelper.Tag getTagInfo(NistHelper.Token token) {
        String type = nextWord(token, NistHelper.TAG_SEP_DOT, 2, false);
        token.pos++;
        String field = nextWord(token, NistHelper.TAG_SEP_COLN, 10, false);
        token.pos++;

        return new NistHelper.Tag(Integer.parseInt(type.replace(",", "")), Integer.parseInt(field));
    }

    protected String nextWord(NistHelper.Token token, char[] sepList, int maxLen, boolean udd) {
        int i = 0;

        while (i < maxLen && token.pos < token.buffer.length && token.buffer[token.pos] != sepList[0] && token.buffer[token.pos] != sepList[1]) {
            token.pos++;
            i++;
        }

        byte[] data = new byte[i];
        System.arraycopy(token.buffer, token.pos - i, data, 0, i);

        try {
            return udd ? String.valueOf(token.charset.decode(ByteBuffer.wrap(data))) : String.valueOf(NistHelper.USASCII.decode(ByteBuffer.wrap(data)));

        } catch (CharacterCodingException e) {
            throw new RuntimeException(e);
        }
    }

    protected long readInt(NistHelper.Token token) {
        byte byte1 = token.buffer[token.pos];
        byte byte2 = token.buffer[token.pos + 1];
        byte byte3 = token.buffer[token.pos + 2];
        byte byte4 = token.buffer[token.pos + 3];

        return (0xFFL & byte1) << 24L | (0xFFL & byte2) << 16L | (0xFFL & byte3) << 8L | 0xFFL & byte4;
    }
}
