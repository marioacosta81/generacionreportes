package org.jnbis;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import org.jnbis.DecodedData.Format;
import org.jnbis.record.FacialAndSmtImage;
import org.jnbis.record.HighResolutionGrayscaleFingerprint;
import org.jnbis.record.VariableResolutionFingerprint;

public class FileUtils {

    public static void save(byte[] data, String name) {
        FileOutputStream bos = null;

        try {
            bos = new FileOutputStream(name);
            bos.write(data);
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        } finally {
            close(bos);
        }

    }

    public static void saveAll(DecodedData decoded, Format format, String path) {
        File directory = new File(path);
        if (directory.exists()) {
            directory.mkdir();
        }

        Iterator i$ = decoded.getFacialSmtKeys().iterator();

        Integer key;
        while (i$.hasNext()) {
            key = (Integer) i$.next();
            FacialAndSmtImage image = decoded.getFacialAndSmtImage(key);
            if (image != null) {
                save(image.getImageData(), path + "/" + key + "." + format.code());
            }
        }

        i$ = decoded.getHiResBinaryFingerPrintKeys().iterator();

        while (i$.hasNext()) {
            key = (Integer) i$.next();
            HighResolutionGrayscaleFingerprint image = decoded.getHiResGrayscaleFingerprint(key);
            if (image != null) {
                save(image.getImageData(), path + "/" + key + "." + format.code());
            }
        }

        i$ = decoded.getVariableResFingerprintKeys().iterator();

        while (i$.hasNext()) {
            key = (Integer) i$.next();
            VariableResolutionFingerprint image = decoded.getVariableResFingerprint(key);
            if (image != null) {
                save(image.getImageData(), path + "/" + key + "." + format.code());
            }
        }

    }

    public static String absoluteFile(String name) {
        URL url = FileUtils.class.getClassLoader().getResource(name);
        return url != null ? url.getFile() : null;
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }

    }
}
