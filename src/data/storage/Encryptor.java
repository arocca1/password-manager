package data.storage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encryptor {
	private static final String ENCRYPTION_KEY = "someLoNgEnCr7PT1";

	public static String encrypt(String s) {
		Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
		try {
			byte[] encryptedBytes = cipher.doFinal(s.getBytes());
			return new String(Base64.encodeBase64(encryptedBytes));
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return null;
	}

	public static String decrypt(String s) {
		Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
		try {
			byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(s.getBytes("UTF-8")));
			return new String(plainBytes);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static Cipher getCipher(int cipherMode) {
		String encryptionAlgorithm = "AES";
		try {
			SecretKeySpec keySpecification = new SecretKeySpec(ENCRYPTION_KEY.getBytes("UTF-8"), encryptionAlgorithm);
			Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
	        cipher.init(cipherMode, keySpecification);
	        return cipher;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
}
