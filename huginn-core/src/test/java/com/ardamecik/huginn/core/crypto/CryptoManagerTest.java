package com.ardamecik.huginn.core.crypto;

import org.junit.jupiter.api.Test;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import static org.junit.jupiter.api.Assertions.*;

public class CryptoManagerTest {

    @Test
    public void testEncryptionDecryption() throws Exception {
        CryptoManager cryptoManager = new CryptoManager();
        SecretKey key = cryptoManager.generateKey(256);
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        
        byte[] originalData = "Huginn Secure Transfer System".getBytes();

        byte[] encryptedData = cryptoManager.encrypt(originalData, key, iv);
        byte[] decryptedData = cryptoManager.decrypt(encryptedData, key, iv);

        assertArrayEquals(originalData, decryptedData);
    }
}