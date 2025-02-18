package com.ioprogramming.advancedproblems.encryptdecryptcsv.test;

import com.ioprogramming.advancedproblems.encryptdecryptcsv.utils.AESCryptoUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncryptDecryptCSVTest {

    @Test
    void testEncryptionDecryption() throws Exception {
        String original = "testData";
        String encrypted = AESCryptoUtil.encrypt(original);
        String decrypted = AESCryptoUtil.decrypt(encrypted);

        assertEquals(original, decrypted);
    }
}
