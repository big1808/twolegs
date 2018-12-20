package com.tedu.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	/**
	 * ʹ��md5���㷨���м���
	 */
	public static String md5(String plainText) {
		// �������ĵ��ֽ�����
		byte[] secretBytes = null;
		try {
			// ����ժҪ�㷨����ȡ���Ķ�Ӧ�����ĵ��ֽ�����
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("û��md5����㷨��");
		}
		// ��2��������ת�� 16���Ƶ��ַ�����ʾ
		String md5code = new BigInteger(1, secretBytes).toString(16);
		// ������Ĳ���32λ���������ַ���ǰ��0������32λ
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}

}
