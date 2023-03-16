package org.jnbis;

import org.jnbis.internal.InternalWsqDecoder;

public class WsqDecoder {

    public Bitmap decode(byte[] data) {
        return (new InternalWsqDecoder()).decode(data);
    }
}
