package org.jnbis;

import org.jnbis.DecodedData.Format;
import org.jnbis.internal.InternalNistDecoder;

public class NistDecoder {

    public DecodedData decode(byte[] nist, Format fingerImageFormat) {
        return (new InternalNistDecoder()).decode(nist, fingerImageFormat);
    }
}
