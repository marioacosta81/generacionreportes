package com.davivienda.generarReporte.util;

import java.util.HashMap;
import java.util.Map;

public final class MimeTypeConstants {

    protected static String s_strDefaultMimeType = "application/pdf";
    protected static String s_strDefaultExtension = "pdf";

    protected static Map<String, String> s_mapMimeTypes = null;

    static {
        s_mapMimeTypes = new HashMap<String, String>(161);
        s_mapMimeTypes.put("application/postscript", "ai");
        s_mapMimeTypes.put("audio/x-aiff", "aif");
        s_mapMimeTypes.put("audio/x-aiff", "aifc");
        s_mapMimeTypes.put("audio/x-aiff", "aiff");
        s_mapMimeTypes.put("text/plain", "asc");
        s_mapMimeTypes.put("video/x.ms.asf", "asf");
        s_mapMimeTypes.put("video/x.ms.asx", "asx");
        s_mapMimeTypes.put("audio/basic", "au");
        s_mapMimeTypes.put("video/x-msvideo", "avi");
        s_mapMimeTypes.put("application/x-bcpio", "bcpio");
        s_mapMimeTypes.put("application/octet-stream", "bin");
        s_mapMimeTypes.put("application/x-cabinet", "cab");
        s_mapMimeTypes.put("application/x-netcdf", "cdf");
        s_mapMimeTypes.put("application/java-vm", "class");
        s_mapMimeTypes.put("application/x-cpio", "cpio");
        s_mapMimeTypes.put("application/mac-compactpro", "cpt");
        s_mapMimeTypes.put("application/x-x509-ca-cert", "crt");
        s_mapMimeTypes.put("application/x-csh", "csh");
        s_mapMimeTypes.put("text/css", "css");
        s_mapMimeTypes.put("text/comma-separated-values", "csv");
        s_mapMimeTypes.put("application/x-director", "dcr");
        s_mapMimeTypes.put("application/x-director", "dir");
        s_mapMimeTypes.put("application/x-msdownload", "dll");
        s_mapMimeTypes.put("application/octet-stream", "dms");
        s_mapMimeTypes.put("application/msword", "doc");
        s_mapMimeTypes.put("application/xml-dtd", "dtd");
        s_mapMimeTypes.put("application/x-dvi", "dvi");
        s_mapMimeTypes.put("application/x-director", "dxr");
        s_mapMimeTypes.put("application/postscript", "eps");
        s_mapMimeTypes.put("text/x-setext", "etx");
        s_mapMimeTypes.put("application/octet-stream", "exe");
        s_mapMimeTypes.put("application/andrew-inset", "ez");
        s_mapMimeTypes.put("image/gif", "gif");
        s_mapMimeTypes.put("application/x-gtar", "gtar");
        s_mapMimeTypes.put("application/gzip", "gz");
        s_mapMimeTypes.put("application/gzip", "gzip");
        s_mapMimeTypes.put("application/x-hdf", "hdf");
        s_mapMimeTypes.put("text/x-component", "htc");
        s_mapMimeTypes.put("application/mac-binhex40", "hqx");
        s_mapMimeTypes.put("text/html", "html");
        s_mapMimeTypes.put("text/html", "htm");
        s_mapMimeTypes.put("x-conference/x-cooltalk", "ice");
        s_mapMimeTypes.put("image/ief", "ief");
        s_mapMimeTypes.put("model/iges", "iges");
        s_mapMimeTypes.put("model/iges", "igs");
        s_mapMimeTypes.put("application/java-archive", "jar");
        s_mapMimeTypes.put("text/plain", "java");
        s_mapMimeTypes.put("application/x-java-jnlp-file", "jnlp");
        s_mapMimeTypes.put("image/jpeg", "jpeg");
        s_mapMimeTypes.put("image/jpeg", "jpe");
        s_mapMimeTypes.put("image/jpeg", "jpg");
        s_mapMimeTypes.put("application/x-javascript", "js");
        s_mapMimeTypes.put("text/plain", "jsp");
        s_mapMimeTypes.put("audio/midi", "kar");
        s_mapMimeTypes.put("application/x-latex", "latex");
        s_mapMimeTypes.put("application/octet-stream", "lha");
        s_mapMimeTypes.put("application/octet-stream", "lzh");
        s_mapMimeTypes.put("application/x-troff-man", "man");
        s_mapMimeTypes.put("application/mathml+xml", "mathml");
        s_mapMimeTypes.put("application/x-troff-me", "me");
        s_mapMimeTypes.put("model/mesh", "mesh");
        s_mapMimeTypes.put("audio/midi", "mid");
        s_mapMimeTypes.put("audio/midi", "midi");
        s_mapMimeTypes.put("application/vnd.mif", "mif");
        s_mapMimeTypes.put("chemical/x-mdl-molfile", "mol");
        s_mapMimeTypes.put("video/x-sgi-movie", "movie");
        s_mapMimeTypes.put("video/quicktime", "mov");
        s_mapMimeTypes.put("audio/mpeg", "mp2");
        s_mapMimeTypes.put("audio/mpeg", "mp3");
        s_mapMimeTypes.put("video/mpeg", "mpeg");
        s_mapMimeTypes.put("video/mpeg", "mpe");
        s_mapMimeTypes.put("audio/mpeg", "mpga");
        s_mapMimeTypes.put("video/mpeg", "mpg");
        s_mapMimeTypes.put("application/x-troff-ms", "ms");
        s_mapMimeTypes.put("model/mesh", "msh");
        s_mapMimeTypes.put("application/octet-stream", "msi");
        s_mapMimeTypes.put("application/x-netcdf", "nc");
        s_mapMimeTypes.put("application/oda", "oda");
        s_mapMimeTypes.put("application/ogg", "ogg");
        s_mapMimeTypes.put("image/x-portable-bitmap", "pbm");
        s_mapMimeTypes.put("chemical/x-pdb", "pdb");
        s_mapMimeTypes.put("application/pdf", "pdf");
        s_mapMimeTypes.put("image/x-portable-graymap", "pgm");
        s_mapMimeTypes.put("application/x-chess-pgn", "pgn");
        s_mapMimeTypes.put("image/png", "png");
        s_mapMimeTypes.put("image/x-portable-anymap", "pnm");
        s_mapMimeTypes.put("image/x-portable-pixmap", "ppm");
        s_mapMimeTypes.put("application/vnd.ms-powerpoint", "ppt");
        s_mapMimeTypes.put("application/postscript", "ps");
        s_mapMimeTypes.put("video/quicktime", "qt");
        s_mapMimeTypes.put("audio/x-pn-realaudio", "ra");
        s_mapMimeTypes.put("audio/x-realaudio", "ra");
        s_mapMimeTypes.put("audio/x-pn-realaudio", "ram");
        s_mapMimeTypes.put("image/x-cmu-raster", "ras");
        s_mapMimeTypes.put("application/rdf+xml", "rdf");
        s_mapMimeTypes.put("image/x-rgb", "rgb");
        s_mapMimeTypes.put("audio/x-pn-realaudio", "rm");
        s_mapMimeTypes.put("application/x-troff", "roff");
        s_mapMimeTypes.put("application/x-rpm", "rpm");
        s_mapMimeTypes.put("audio/x-pn-realaudio", "rpm");
        s_mapMimeTypes.put("application/rtf", "rtf");
        s_mapMimeTypes.put("text/richtext", "rtx");
        s_mapMimeTypes.put("application/java-serialized-object", "ser");
        s_mapMimeTypes.put("text/sgml", "sgml");
        s_mapMimeTypes.put("text/sgml", "sgm");
        s_mapMimeTypes.put("application/x-sh", "sh");
        s_mapMimeTypes.put("application/x-shar", "shar");
        s_mapMimeTypes.put("model/mesh", "silo");
        s_mapMimeTypes.put("application/x-stuffit", "sit");
        s_mapMimeTypes.put("application/x-koan", "skd");
        s_mapMimeTypes.put("application/x-koan", "skm");
        s_mapMimeTypes.put("application/x-koan", "skp");
        s_mapMimeTypes.put("application/x-koan", "skt");
        s_mapMimeTypes.put("application/smil", "smi");
        s_mapMimeTypes.put("application/smil", "smil");
        s_mapMimeTypes.put("audio/basic", "snd");
        s_mapMimeTypes.put("application/x-futuresplash", "spl");
        s_mapMimeTypes.put("application/x-wais-source", "src");
        s_mapMimeTypes.put("application/x-sv4cpio", "sv4cpio");
        s_mapMimeTypes.put("application/x-sv4crc", "sv4crc");
        s_mapMimeTypes.put("image/svg+xml", "svg");
        s_mapMimeTypes.put("application/x-shockwave-flash", "swf");
        s_mapMimeTypes.put("application/x-troff", "t");
        s_mapMimeTypes.put("application/x-tar", "tar");
        s_mapMimeTypes.put("application/x-gtar", "tar.gz");
        s_mapMimeTypes.put("application/x-tcl", "tcl");
        s_mapMimeTypes.put("application/x-tex", "tex");
        s_mapMimeTypes.put("application/x-texinfo", "texi");
        s_mapMimeTypes.put("application/x-texinfo", "texinfo");
        s_mapMimeTypes.put("application/x-gtar", "tgz");
        s_mapMimeTypes.put("image/tiff", "tiff");
        s_mapMimeTypes.put("image/tiff", "tif");
        s_mapMimeTypes.put("application/x-troff", "tr");
        s_mapMimeTypes.put("text/tab-separated-values", "tsv");
        s_mapMimeTypes.put("text/plain", "txt");
        s_mapMimeTypes.put("application/x-ustar", "ustar");
        s_mapMimeTypes.put("application/x-cdlink", "vcd");
        s_mapMimeTypes.put("model/vrml", "vrml");
        s_mapMimeTypes.put("application/voicexml+xml", "vxml");
        s_mapMimeTypes.put("audio/x-wav", "wav");
        s_mapMimeTypes.put("image/vnd.wap.wbmp", "wbmp");
        s_mapMimeTypes.put("application/vnd.wap.wmlc", "wmlc");
        s_mapMimeTypes.put("application/vnd.wap.wmlscriptc", "wmlsc");
        s_mapMimeTypes.put("text/vnd.wap.wmlscript", "wmls");
        s_mapMimeTypes.put("text/vnd.wap.wml", "wml");
        s_mapMimeTypes.put("model/vrml", "wrl");
        s_mapMimeTypes.put("application/vnd.wap.wtls-ca-certificate", "wtls-ca-certificate");
        s_mapMimeTypes.put("image/x-xbitmap", "xbm");
        s_mapMimeTypes.put("application/xhtml+xml", "xht");
        s_mapMimeTypes.put("application/xhtml+xml", "xhtml");
        s_mapMimeTypes.put("application/vnd.ms-excel", "xls");
        s_mapMimeTypes.put("application/xml", "xml");
        s_mapMimeTypes.put("image/x-xpixmap", "xpm");
        s_mapMimeTypes.put("image/x-xpixmap", "xpm");
        s_mapMimeTypes.put("application/xml", "xsl");
        s_mapMimeTypes.put("application/xslt+xml", "xslt");
        s_mapMimeTypes.put("application/vnd.mozilla.xul+xml", "xul");
        s_mapMimeTypes.put("image/x-xwindowdump", "xwd");
        s_mapMimeTypes.put("chemical/x-xyz", "xyz");
        s_mapMimeTypes.put("application/compress", "z");
        s_mapMimeTypes.put("application/zip", "zip");
    }

    public static String getExtension(String strKey) {
        String strExtension = s_mapMimeTypes.get(strKey);
        if (strExtension == null || strExtension.trim().length() == 0) {
            strExtension = s_strDefaultExtension;
        }
        return strExtension;
    }

    public static String getMimeType(String strValue) {
        for (Map.Entry<String, String> entry : s_mapMimeTypes.entrySet()) {
            if (((String) entry.getValue()).equals(strValue)) {
                return entry.getKey();
            }
        }
        return s_strDefaultMimeType;
    }
}
