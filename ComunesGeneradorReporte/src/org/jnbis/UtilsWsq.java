package org.jnbis;

import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class UtilsWsq {

    public String wsq2png(String contenido) {
        WsqDecoder wsqDecoder = new WsqDecoder();
        ImageUtils imageUtils = new ImageUtils();
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            byte[] imageByte = decoder.decodeBuffer(contenido);
            Bitmap decoded1 = wsqDecoder.decode(imageByte);
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(imageUtils.bitmap2png(decoded1));
        } catch (IOException var8) {
            return null;
        }
    }
}
