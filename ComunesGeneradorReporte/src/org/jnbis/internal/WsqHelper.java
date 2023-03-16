package org.jnbis.internal;

public class WsqHelper {

    static int[] BITMASK = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255};

    static final int MAX_DHT_TABLES = 8;

    static final int MAX_HUFFBITS = 16;
    static final int MAX_HUFFCOUNTS_WSQ = 256;
    static final int W_TREELEN = 20;
    static final int Q_TREELEN = 64;
    static final int SOI_WSQ = 65440;
    static final int EOI_WSQ = 65441;
    static final int SOF_WSQ = 65442;
    static final int SOB_WSQ = 65443;
    static final int DTT_WSQ = 65444;
    static final int DQT_WSQ = 65445;
    static final int DHT_WSQ = 65446;
    static final int DRT_WSQ = 65447;
    static final int COM_WSQ = 65448;
    static final int STRT_SUBBAND_2 = 19;
    static final int STRT_SUBBAND_3 = 52;
    static final int MAX_SUBBANDS = 64;
    static final int NUM_SUBBANDS = 60;
    static final int STRT_SUBBAND_DEL = 60;
    static final int STRT_SIZE_REGION_2 = 4;
    static final int STRT_SIZE_REGION_3 = 51;
    static final int ANY_WSQ = 65535;
    static final int TBLS_N_SOF = 2;
    static final int TBLS_N_SOB = 4;

    static class WavletTree {

        int x;
        int y;
        int lenx;
        int leny;
        int invrw;
        int invcl;
    }

    static class TableDTT {

        float[] lofilt;
        float[] hifilt;
        int losz;
        int hisz;
        int lodef;
        int hidef;
    }

    static class HuffCode {

        int size;
        int code;
    }

    static class HeaderFrm {

        int black;
        int white;
        int width;
        int height;
        float mShift;
        float rScale;
        int wsqEncoder;
        int software;
    }

    static class HuffmanTable {

        int tableLen;
        int bytesLeft;
        int tableId;
        int[] huffbits;
        int[] huffvalues;
    }

    static class TableDHT {

        private static final int MAX_HUFFBITS = 16;
        private static final int MAX_HUFFCOUNTS_WSQ = 256;
        byte tabdef;
        int[] huffbits = new int[16];
        int[] huffvalues = new int[257];
    }

    static class Table_DQT {

        public static final int MAX_SUBBANDS = 64;
        float binCenter;
        float[] qBin = new float[64];
        float[] zBin = new float[64];
        char dqtDef;
    }

    static class QuantTree {

        int x;
        int y;
        int lenx;
        int leny;
    }

    static class IntRef {

        int value;

        public IntRef(int value) {
            this.value = value;
        }
    }

    static class Token {

        WsqHelper.TableDHT[] tableDHT;

        WsqHelper.TableDTT tableDTT;

        WsqHelper.Table_DQT tableDQT;
        WsqHelper.WavletTree[] wtree;
        WsqHelper.QuantTree[] qtree;
        byte[] buffer;
        int pointer;

        Token(byte[] buffer) {
            this.buffer = buffer;
            this.pointer = 0;
        }

        void initialize() {
            this.tableDTT = new WsqHelper.TableDTT();
            this.tableDQT = new WsqHelper.Table_DQT();

            this.tableDHT = new WsqHelper.TableDHT[8];
            for (int i = 0; i < 8; i++) {
                this.tableDHT[i] = new WsqHelper.TableDHT();
                (this.tableDHT[i]).tabdef = 0;
            }
        }

        long readInt() {
            byte byte1 = this.buffer[this.pointer++];
            byte byte2 = this.buffer[this.pointer++];
            byte byte3 = this.buffer[this.pointer++];
            byte byte4 = this.buffer[this.pointer++];

            return (0xFFL & byte1) << 24L | (0xFFL & byte2) << 16L | (0xFFL & byte3) << 8L | 0xFFL & byte4;
        }

        int readShort() {
            int byte1 = this.buffer[this.pointer++];
            int byte2 = this.buffer[this.pointer++];

            return (0xFF & byte1) << 8 | 0xFF & byte2;
        }

        int readByte() {
            byte byte1 = this.buffer[this.pointer++];

            return 0xFF & byte1;
        }

        byte[] readBytes(int size) {
            byte[] bytes = new byte[size];

            for (int i = 0; i < size; i++) {
                bytes[i] = this.buffer[this.pointer++];
            }

            return bytes;
        }
    }

    static boolean isWsqFormat(byte[] bytes) {
        return (bytes[0] == -1 && bytes[1] == -96 && bytes[bytes.length - 2] == -1 && bytes[bytes.length - 1] == -95);
    }
}
