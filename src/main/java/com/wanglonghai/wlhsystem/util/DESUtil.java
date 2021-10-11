package com.wanglonghai.wlhsystem.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

public class DESUtil {
	private static String password = "9588888888880288";

	// 测试
	public static void main(String args[]) throws Exception {
		// 待加密内容
		String str = "中国aada6^&add";
		// 密码，长度要是8的倍数
		// 为了加密让浏览器支持,需要encode和decode
		byte[] result = DESUtil.encrypt(str.getBytes());
		System.out.println("加密后：" + URLEncoder.encode(URLEncoder.encode(new String(result), "UTF-8"), "UTF-8"));

		// 直接将如上内容解密
		try {
			byte[] decryResult = DESUtil.decrypt(result);
			System.out
					.println("解密后：" + URLDecoder.decode(URLDecoder.decode(new String(decryResult), "UTF-8"), "UTF-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * 加密
	 * 
	 * @param datasource byte[]
	 * @param password   String
	 * @return byte[]
	 */
	public static byte[] encrypt(byte[] datasource) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param src      byte[]
	 * @param password String
	 * @return byte[]
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * 
	 * @return
	 * 
	 */

	public static byte[] parseHexStr2Byte(String hexStr) {

		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}

		return result;
	}


}
