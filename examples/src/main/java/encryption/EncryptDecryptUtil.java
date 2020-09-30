package encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptUtil {
	
	private static final String myEncryptionKey;
	private static final  String UNICODE_UTF8_FORMAT;
	public static final String DESEDE_ENCRYPTION_SCHEME;
	private static final String myEncryptionScheme;
	private static  KeySpec keySpec;
	private static  byte[] arrayBytes;	
	private static  SecretKeyFactory secretKeyFactory;
	private static  SecretKey key;
    private static  Cipher cipher;
	
    
	static {
		
		myEncryptionKey = "enCr!pt!0nK#yS@ltF0rP@SSw0rd";		
		UNICODE_UTF8_FORMAT = "UTF8";
		DESEDE_ENCRYPTION_SCHEME = "DESede";
		myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		try {
			arrayBytes = myEncryptionKey.getBytes(UNICODE_UTF8_FORMAT);
			keySpec = new DESedeKeySpec(arrayBytes);
			secretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
			key = secretKeyFactory.generateSecret(keySpec);
			cipher = Cipher.getInstance(myEncryptionScheme);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} 
	}

	public static String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_UTF8_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }


    public static String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }   

}