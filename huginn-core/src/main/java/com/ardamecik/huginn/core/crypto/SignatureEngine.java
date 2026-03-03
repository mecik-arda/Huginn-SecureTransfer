package com.ardamecik.huginn.core.crypto;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class SignatureEngine {

    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    public byte[] signData(byte[] data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public boolean verifySignature(byte[] data, byte[] digitalSignature, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(digitalSignature);
    }
}
