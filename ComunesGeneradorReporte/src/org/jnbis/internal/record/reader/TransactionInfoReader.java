package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.record.TransactionInformation;

public class TransactionInfoReader
        extends RecordReader {

    public TransactionInformation read(NistHelper.Token token) {
        if (token.pos >= token.buffer.length) {
            throw new RuntimeException("T1::NULL pointer to T1 record");
        }

        TransactionInformation transaction = new TransactionInformation();

        do {
            NistHelper.Tag tag = getTagInfo(token);

            if (tag.type != 1) {
                throw new RuntimeException("T1::Invalid Record Type : " + tag.type);
            }

            String value = nextWord(token, NistHelper.TAG_SEP_GSFS, 1023, false);

            switch (tag.field) {
                case 1:
                    transaction.setLogicalRecordLength(value);
                    break;
                case 2:
                    transaction.setVersion(value);
                    break;
                case 3:
                    token.header = value;
                    transaction.setFileContent(value);
                    break;
                case 4:
                    transaction.setTypeOfTransaction(value);
                    break;
                case 5:
                    transaction.setDate(value);
                    break;
                case 6:
                    transaction.setPriority(value);
                    break;
                case 7:
                    transaction.setDestinationAgencyId(value);
                    break;
                case 8:
                    transaction.setOriginatingAgencyId(value);
                    break;
                case 9:
                    transaction.setControlNumber(value);
                    break;
                case 10:
                    transaction.setControlReferenceNumber(value);
                    break;
                case 11:
                    transaction.setNativeScanningResolution(value);
                    break;
                case 12:
                    transaction.setNominalTransmittingResolution(value);
                    break;
                case 13:
                    transaction.setDomainName(value);
                    break;
                case 14:
                    transaction.setGreenwichMeanTime(value);
                    break;
                case 15:
                    token.setCharSetDecoder(value);
                    transaction.setDirectoryOfCharsets(value);
                    break;
            }

        } while (token.buffer[token.pos++] != 28);

        return transaction;
    }
}
