package pw.bullseye.monitor.util;

import java.util.Base64;

/**
 * @author Brennan / skateboard
 * @since 3/2/2022
 **/
public class EncryptionUtil {

    public static String decrypt(String s, String key) {
        return new String(xor(base64Decode(s), key.getBytes()));
    }

    private static byte[] xor(byte[] a, byte[] key) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ key[i%key.length]);
        }

        return out;
    }

    private static byte[] base64Decode(String s) {
        return Base64.getDecoder().decode(s);
    }
}
