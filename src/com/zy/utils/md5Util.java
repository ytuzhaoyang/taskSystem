package com.zy.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class md5Util {

	public static String md5(String pwd){
		
		String mds = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte [] bytes = digest.digest(pwd.getBytes());
			StringBuilder builder = new StringBuilder();
			for(byte b:bytes){
				int num = b&0xff;
				String hexString = Integer.toHexString(num);
				if(hexString.length()<2){
					builder.append("0");
				}
				builder.append(hexString);
			}
			mds = builder.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mds;
	}
}
