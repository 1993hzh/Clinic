package com.ibm.train.util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @author HuZhonghua
 *
 */
public class Encryption {
	public static String encoderBySHA1(String str) {
		if (null == str) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1"); // 确定计算方法
			return Base64.encodeBase64String(md.digest(str.getBytes("utf-8")))
					.trim();// 返回加密后的字符串
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
