package com.demo.DynamicMBean;

public class UTF8UrlEncoder {
    private static final boolean encodeSpaceUsingPlus = true;
    private static final int[] SAFE_ASCII = new int[128];
    private static final char[] HEX;

    static {
        int i;
        for (i = 97; i <= 122; ++i) {
            SAFE_ASCII[i] = 1;
        }

        for (i = 65; i <= 90; ++i) {
            SAFE_ASCII[i] = 1;
        }

        for (i = 48; i <= 57; ++i) {
            SAFE_ASCII[i] = 1;
        }

        SAFE_ASCII[45] = 1;
        SAFE_ASCII[46] = 1;
        SAFE_ASCII[95] = 1;
        SAFE_ASCII[126] = 1;
        HEX = "0123456789ABCDEF".toCharArray();
    }

    private UTF8UrlEncoder() {
    }

    public static String encode(String input) {
        StringBuilder sb = new StringBuilder(input.length() + 16);
        appendEncoded(sb, input);
        return sb.toString();
    }

    public static StringBuilder appendEncoded(StringBuilder sb, String input) {
        int[] safe = SAFE_ASCII;
        int i = 0;

        for (int len = input.length(); i < len; ++i) {
            char c = input.charAt(i);
            if (c <= 127) {
                if (safe[c] != 0) {
                    sb.append(c);
                } else {
                    appendSingleByteEncoded(sb, c);
                }
            } else {
                appendMultiByteEncoded(sb, c);
            }
        }

        return sb;
    }

    private static final void appendSingleByteEncoded(StringBuilder sb, int value) {
        if (encodeSpaceUsingPlus && value == 32) {
            sb.append('+');
        } else {
            sb.append('%');
            sb.append(HEX[value >> 4]);
            sb.append(HEX[value & 15]);
        }
    }

    private static final void appendMultiByteEncoded(StringBuilder sb, int value) {
        if (value < 2048) {
            appendSingleByteEncoded(sb, 192 | value >> 6);
            appendSingleByteEncoded(sb, 128 | value & 63);
        } else {
            appendSingleByteEncoded(sb, 224 | value >> 12);
            appendSingleByteEncoded(sb, 128 | value >> 6 & 63);
            appendSingleByteEncoded(sb, 128 | value & 63);
        }

    }
}
