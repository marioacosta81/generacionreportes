package org.jnbis.internal;

import org.jnbis.Bitmap;
import org.jnbis.DecodedData;
import org.jnbis.ImageUtils;
import org.jnbis.DecodedData.Format;
import org.jnbis.internal.NistHelper.Token;
import org.jnbis.internal.record.BaseRecord;
import org.jnbis.internal.record.reader.factory.RecordReaderFactory;
import org.jnbis.record.FacialAndSmtImage;
import org.jnbis.record.HighResolutionBinaryFingerprint;
import org.jnbis.record.HighResolutionGrayscaleFingerprint;
import org.jnbis.record.IrisImage;
import org.jnbis.record.LowResolutionBinaryFingerprint;
import org.jnbis.record.LowResolutionGrayscaleFingerprint;
import org.jnbis.record.MinutiaeData;
import org.jnbis.record.SignatureImage;
import org.jnbis.record.TransactionInformation;
import org.jnbis.record.UserDefinedDescriptiveText;
import org.jnbis.record.UserDefinedImage;
import org.jnbis.record.VariableResolutionFingerprint;
import org.jnbis.record.VariableResolutionLatentImage;
import org.jnbis.record.VariableResolutionPalmprint;

public class InternalNistDecoder {

    private InternalWsqDecoder wsqDecoder = new InternalWsqDecoder();
    private ImageUtils imageUtils = new ImageUtils();
    private RecordReaderFactory readerFactory = new RecordReaderFactory();

    public DecodedData decode(byte[] nist, Format fingerImageFormat) {
        if (nist != null && nist.length != 0) {
            Token token = new Token(nist);
            InternalDecodedData decoded = new InternalDecodedData();
            BaseRecord record = this.readerFactory.read(token);
            decoded.putTransactionInfo(decoded.getTransactionKeys().size(), (TransactionInformation) record);

            while (this.nextRecord(token)) {
                if (token.crt >= 2) {
                    record = this.readerFactory.read(token);
                    if (record instanceof UserDefinedDescriptiveText) {
                        decoded.putUserDefinedText(decoded.getUserDefinedTextKeys().size(), (UserDefinedDescriptiveText) record);
                    } else if (record instanceof LowResolutionGrayscaleFingerprint) {
                        LowResolutionGrayscaleFingerprint fingerprint = (LowResolutionGrayscaleFingerprint) record;
                        decoded.putLowResGrayscaleFingerPrint(decoded.getLowResGrayscaleFingerPrintKeys().size(), fingerprint);
                    } else if (record instanceof HighResolutionGrayscaleFingerprint) {
                        HighResolutionGrayscaleFingerprint fingerprint = (HighResolutionGrayscaleFingerprint) record;
                        if (WsqHelper.isWsqFormat(fingerprint.getImageData())) {
                            Bitmap bitmap = this.wsqDecoder.decode(fingerprint.getImageData());
                            switch (fingerImageFormat) {
                                case JPEG:
                                    fingerprint.setImageData(this.imageUtils.bitmap2jpeg(bitmap));
                                    break;
                                case GIF:
                                    fingerprint.setImageData(this.imageUtils.bitmap2gif(bitmap));
                                    break;
                                case PNG:
                                    fingerprint.setImageData(this.imageUtils.bitmap2png(bitmap));
                                    break;
                                default:
                                    throw new RuntimeException("unsupported image format.");
                            }
                        }

                        decoded.putHiResGrayscaleFingerPrint(decoded.getHiResGrayscaleFingerPrintKeys().size(), fingerprint);
                    } else if (record instanceof LowResolutionBinaryFingerprint) {
                        LowResolutionBinaryFingerprint fingerprint = (LowResolutionBinaryFingerprint) record;
                        decoded.putLowResBinaryFingerPrint(decoded.getLowResBinaryFingerPrintKeys().size(), fingerprint);
                    } else if (record instanceof HighResolutionBinaryFingerprint) {
                        HighResolutionBinaryFingerprint fingerprint = (HighResolutionBinaryFingerprint) record;
                        decoded.putHiResBinaryFingerPrint(decoded.getHiResBinaryFingerPrintKeys().size(), fingerprint);
                    } else if (record instanceof UserDefinedImage) {
                        decoded.putUserDefinedImage(decoded.getUserDefinedImageKeys().size(), (UserDefinedImage) record);
                    } else if (record instanceof SignatureImage) {
                        decoded.putSignature(decoded.getSignatureKeys().size(), (SignatureImage) record);
                    } else if (record instanceof MinutiaeData) {
                        decoded.putMinutiaeData(decoded.getMinutiaeDataKeys().size(), (MinutiaeData) record);
                    } else if (record instanceof FacialAndSmtImage) {
                        decoded.putFacialSmtImage(decoded.getFacialSmtKeys().size(), (FacialAndSmtImage) record);
                    } else if (record instanceof VariableResolutionLatentImage) {
                        decoded.putVariableResLatentImage(decoded.getVariableResLatentImageKeys().size(), (VariableResolutionLatentImage) record);
                    } else if (record instanceof VariableResolutionFingerprint) {
                        decoded.putVariableResFingerprint(decoded.getVariableResFingerprintKeys().size(), (VariableResolutionFingerprint) record);
                    } else if (record instanceof VariableResolutionPalmprint) {
                        decoded.putVariableResPalmprint(decoded.getVariableResPalmprintKeys().size(), (VariableResolutionPalmprint) record);
                    } else if (record instanceof IrisImage) {
                        decoded.putIrisImage(decoded.getIrisImageKeys().size(), (IrisImage) record);
                    }
                }
            }

            return decoded;
        } else {
            throw new IllegalArgumentException("data is null or zero length");
        }
    }

    private boolean nextRecord(Token token) {
        if (token.header.length() == 0) {
            return false;
        } else {
            int rsPos = token.header.indexOf(30);
            if (rsPos == -1) {
                rsPos = token.header.length() - 1;
            }

            int usPos = token.header.indexOf(31);
            token.crt = Integer.parseInt(token.header.substring(0, usPos));
            token.header = token.header.substring(rsPos + 1);
            return true;
        }
    }

    // $FF: synthetic class
    static class SyntheticClass_1 {
        // $FF: synthetic field

        static final int[] $SwitchMap$org$jnbis$DecodedData$Format = new int[Format.values().length];

        static {
            try {
                $SwitchMap$org$jnbis$DecodedData$Format[Format.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError var3) {
                ;
            }

            try {
                $SwitchMap$org$jnbis$DecodedData$Format[Format.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError var2) {
                ;
            }

            try {
                $SwitchMap$org$jnbis$DecodedData$Format[Format.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError var1) {
                ;
            }

        }
    }
}
