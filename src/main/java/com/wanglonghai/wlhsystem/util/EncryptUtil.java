package com.wanglonghai.wlhsystem.util;

import java.security.MessageDigest;

public class EncryptUtil {
	
	public static final String sha1Encode(String source) {

		return encode(source, "SHA-1");
	}
	public static final String md5Encode(String source) {

		return encode(source, "MD5");
	}
	public static final String encode(String source, String algorithm) {

		try {
			MessageDigest alga = MessageDigest.getInstance(algorithm);
			alga.update(source.getBytes("UTF-8"));
			byte[] digesta = alga.digest();
			return toHex(digesta);
		} catch (Exception e) {
			return null;
		}
	}
	
	private static final String toHex(byte[] bytes) {

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			if (Integer.toHexString(0xFF & bytes[i]).length() == 1)
				result.append("0").append(Integer.toHexString(0xFF & bytes[i]));
			else
				result.append(Integer.toHexString(0xFF & bytes[i]));
		}
		return result.toString();
	}
}
