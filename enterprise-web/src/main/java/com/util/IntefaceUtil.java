package com.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class IntefaceUtil {
	private static final String IV = "5954836451581950";
    //密钥
    private static final String secretkey = AppPropertiesUtil.getValue("secretInterkey");
    //加密
    public static String encrypt(String strIn) throws Exception {	
        SecretKeySpec skeySpec = getKey(secretkey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(strIn.getBytes("UTF-8"));
        return org.apache.commons.codec.binary.Base64.encodeBase64String(encrypted);
    }
    //解密
    public static String decrypt(String strIn) throws Exception {
    	strIn = strIn.trim();
        SecretKeySpec skeySpec = getKey(secretkey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = org.apache.commons.codec.binary.Base64.decodeBase64(strIn);
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original,"UTF-8");
        return originalString;
    }

    private static SecretKeySpec getKey(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes("UTF-8");
        byte[] arrB = new byte[16];
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");
        return skeySpec;
    } 
    public static void main(String[] args) {
    	String org ="j0zjwsVhNDaZ4cUlERU6Po0SbvO8S/wocCD4os4TnpJoY1RqBzL6j7GikBIDErVmrivb+Rqi0ImsyIJCpKNPsVvDpYYEUa1zKjLUG20vUnIHQTm2BaOiU70lnT3tfi3z";
    	String ty="";
		try {
			ty = decrypt(org);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.err.println(ty);
	}
}
