package com.util;


import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanggangyi on 17/3/28.
 */
public class UrlEncode {

    /**
     * 加解密因子，不可修改
     */
    private static String SECURE_ID = "andedu";

    public static void main(String[] args) {
        /**
         * 原URL
         */
        String orginUrl = "http://doc.media.andedu.net:9000/product/cp_huodong/hdys/etdw/antushengtonghuaji.PDF";
        //转防盗链
        String url = encode(orginUrl);
        System.out.println(url);
    }

    /**
     * URL 防盗链
     * @param orginUrl 原路径
     * @return 防盗路径
     */
    public static String encode(String orginUrl){
        /**
         * 请域名部分
         */
        String domain = orginUrl.substring(0, orginUrl.lastIndexOf(":")+5);
        /**
         * 请求文件路径部分
         */
        String fileName = orginUrl.substring(orginUrl.lastIndexOf(":")+5);
        /**
         * 服务器当前时间，要求服务器时间与CDN时间差较小，否则导致请求过期，过期时间5分钟
         */
        String timeId = getCurrentDate("yyyyMMddHHmm");
        /**
         * 以timeId、fileName和预先设定好的SECURE_ID共同做MD5获得的字符串，即md5（SECURE_ID+timeId+fileName）
         */
        String hashId = MD5Encode(SECURE_ID + timeId + fileName, "UTF-8");
        /**
         * 防盗URL
         */
        String url = domain + "/" + timeId + "/" + hashId + fileName;
        return url;
    }


    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /***
     * 获取指定格式的当前系统时间
     * @param pattern
     * @return
     */
    public static String getCurrentDate(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
