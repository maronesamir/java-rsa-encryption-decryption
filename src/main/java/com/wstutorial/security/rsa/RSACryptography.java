package com.wstutorial.security.rsa;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSACryptography {

    private static final String ALGORITHM_RSA = "RSA";

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        keyGen.initialize(2048);

        KeyPair generatedKeyPair = keyGen.generateKeyPair();
        return generatedKeyPair;
    }

    public static byte[] encrypt(PublicKey key, String message)
            throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return encryptedBytes;
    }

    public static byte[] decrypt(PrivateKey key, byte[] encryptMessage)
            throws Exception {

        Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedBytes = cipher.doFinal(encryptMessage);

        return decryptedBytes;
    }

}
