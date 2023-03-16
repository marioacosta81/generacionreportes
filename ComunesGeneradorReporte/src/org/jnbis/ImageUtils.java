package org.jnbis;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {

    public static final int[] MASKS = new int[]{255, 255, 255};

    public byte[] bitmap2jpeg(Bitmap bitmap) {
        return this.convert(bitmap, "jpeg");
    }

    public byte[] bitmap2gif(Bitmap bitmap) {
        return this.convert(bitmap, "gif");
    }

    public byte[] bitmap2png(Bitmap bitmap) {
        return this.convert(bitmap, "png");
    }

    private byte[] convert(Bitmap bitmap, String format) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        DataBuffer buffer = new DataBufferByte(bitmap.getPixels(), bitmap.getLength());
        WritableRaster writableRaster = Raster.createPackedRaster(buffer, width, height, width, MASKS, (Point) null);
        BufferedImage bimage = new BufferedImage(width, height, 1);
        bimage.setData(writableRaster);
        ByteArrayOutputStream bstream = new ByteArrayOutputStream();

        try {
            ImageIO.write(bimage, format, bstream);
            bstream.close();
            return bstream.toByteArray();
        } catch (IOException var10) {
            throw new RuntimeException(var10);
        }
    }
}
