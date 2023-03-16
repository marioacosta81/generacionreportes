package org.jnbis;

import java.io.Serializable;

public class Bitmap
        implements Serializable {

    private final byte[] pixels;
    private final int width;
    private final int height;
    private final int ppi;
    private final int depth;
    private final int lossyFlag;
    private final int length;

    public Bitmap(byte[] pixels, int width, int height, int ppi, int depth, int lossyFlag) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.depth = depth;
        this.lossyFlag = lossyFlag;

        this.length = (pixels != null) ? pixels.length : 0;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getPpi() {
        return this.ppi;
    }

    public byte[] getPixels() {
        return this.pixels;
    }

    public int getLength() {
        return this.length;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getLossyFlag() {
        return this.lossyFlag;
    }
}
