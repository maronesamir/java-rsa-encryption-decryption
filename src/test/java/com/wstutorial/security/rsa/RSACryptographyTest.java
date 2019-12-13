package com.wstutorial.security.rsa;

import org.junit.Test;

import java.security.KeyPair;
import java.security.PublicKey;

import static org.junit.Assert.assertTrue;

public class RSACryptographyTest {
    final private String orginalMessage = "wstutorial.com";

    @Test
    public void testA() throws Exception {
        KeyPair keyPair = RSACryptography.generateKeyPair();
        byte[] publicKey = keyPair.getPublic().getEncoded();
        byte[] privateKey = keyPair.getPrivate().getEncoded();

        PublicKey pKey = keyPair.getPublic();

        byte[] encryptedMessage = RSACryptography.encrypt(keyPair.getPublic(), orginalMessage);
        System.out.println("encryptedMessage:");
        System.out.println(new String(encryptedMessage));

        byte[] decryptedMessage = RSACryptography.decrypt(keyPair.getPrivate(), encryptedMessage);
        System.out.println("decryptedMessage: " + new String(decryptedMessage));

        assertTrue(orginalMessage.equals(new String(decryptedMessage)));
    }

}