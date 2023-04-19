package com.makeorder.security;

import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureVerifier {
	
	private PublicKey publicKey;

    public DigitalSignatureVerifier(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public boolean verifySignature(byte[] data, byte[] signature) throws Exception {
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(publicKey);
        sig.update(data);
        return sig.verify(signature);
    }
	
}
