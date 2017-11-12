package com.eduworld.authentication;

import java.security.spec.KeySpec;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.fis.security.exceptions.ApplicationAuthenticationException;

public class CryptoSecurityApp {

	private String SECUTY_SPLITTER;
	private String securFormat;

	private final String uniCodeFormat;
	private final String encryptScheme;
	private final String encryptKey;

	final private KeySpec keySpec;
	final private SecretKeyFactory skf;
	final private Cipher cipher;
	final private byte[] arrayBytes;
	final private String myEncryptrionKey = "ThisIsSpartaThisIsSparta";
	// String myEncryptionScheme = DESEDE_ENCRY_SCHEME;
	final private SecretKey key;

	public CryptoSecurityApp(String uniCodeFormat, String encryptScheme, String encryptKey) throws Exception {
		this.uniCodeFormat = uniCodeFormat;
		this.encryptScheme = encryptScheme;
		this.encryptKey = encryptKey;
		this.arrayBytes = myEncryptrionKey.getBytes(uniCodeFormat);
		this.keySpec = new DESedeKeySpec(arrayBytes);
		this.skf = SecretKeyFactory.getInstance(encryptScheme);
		this.cipher = Cipher.getInstance(encryptScheme);
		this.key = skf.generateSecret(keySpec);
	}

	public String ecrypt(String unEncryptedString) throws Exception {
		final String encString;
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] plaiText = unEncryptedString.getBytes(uniCodeFormat);
		byte[] encrypText = cipher.doFinal(plaiText);
		encString = new String(Base64.encodeBase64(encrypText));

		return encString;
	}

	public String decrypt(String encryString) throws Exception {
		String dencString = null;
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] encrypText = Base64.decodeBase64(encryString.getBytes());
		byte[] plainText = cipher.doFinal(encrypText);
		return dencString = new String(plainText);
	}

	public String[] getDecryptSecur(String securityCode) throws Exception {
		String result[] = null;
		final String decCode;
		// decCode = decrypt(securityCode);
		if (!StringUtils.isEmpty(securityCode)) {
			decCode = decrypt(securityCode);
			if (!StringUtils.isEmpty(decCode)) {
				result = decCode.split(SECUTY_SPLITTER);
				if (result != null && result.length == 2) {
					return result;
				}
			}
		}
		// StringTokenizer strToken = new StringTokenizer(securityCode,
		// SECUTY_SPLITTER);

		else {
			throw new ApplicationAuthenticationException("X-Auth-Token pattern is invalid");
		}
		return result;
	}

	public boolean getAuthenticateion(String secCode) throws Exception {
		boolean isAuth = false;
		final String[] result;
		final Long timeInMills;

		result = getDecryptSecur(secCode);
		timeInMills = Long.valueOf(result[1]);
		if (StringUtils.equals(result[0], securFormat) && timeInMills instanceof Long) {
			if (timeInMills >= new Date().getTime()) {
				return isAuth = true;
			} else {
				throw new ApplicationAuthenticationException("X-Auth-Token time expired");
			}
		}
		return isAuth;
	}

	public void setSecurFormat(String securFormat) {
		this.securFormat = securFormat;
	}

	public void setSECUTY_SPLITTER(String sECUTY_SPLITTER) {
		SECUTY_SPLITTER = sECUTY_SPLITTER;
	}

}
