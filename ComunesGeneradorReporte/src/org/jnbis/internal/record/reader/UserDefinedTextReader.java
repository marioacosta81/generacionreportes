package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.UserDefinedDescriptiveText;

public class UserDefinedTextReader
        extends RecordReader {

    public UserDefinedDescriptiveText read(NistHelper.Token token) {
        String value;
        NistHelper.Tag tag;
        if (token.pos >= token.buffer.length) {
            throw new IllegalArgumentException("T2::NULL pointer to T2 record");
        }

        UserDefinedDescriptiveText userDefinedText = new UserDefinedDescriptiveText();

        do {
            tag = getTagInfo(token);

            if (tag.type != 2) {
                throw new RuntimeException("T2::Invalid Record type = " + tag.type);
            }

            value = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, true);
            userDefinedText.addUserDefinedField(Integer.valueOf(tag.field), value);
        } while (token.buffer[token.pos++] != 28);

        return userDefinedText;
    }
}
