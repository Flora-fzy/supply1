package com.jdt.sdkdemo1.supply.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class DES3Utils {

    /**
     * 定义 加密算法,可用 DES,DESede,Blowfish
     */
    private static final String ALGORITHM = "DESede";


    public static String decrypt(String value, String key) throws Exception {
        byte[] b = decryptMode(getKeyBytes(key), Base64.decode(value));
        return new String(b, Charset.defaultCharset());
    }

    public static String encrypt(String value, String key) throws Exception {
        return byte2Base64(encryptMode(getKeyBytes(key), value.getBytes(Charset.defaultCharset())));
    }

    /**
     * 计算24位长的密码byte值,首先对原始密钥做MD5算hash值，再用前8位数据对应补全后8位
     */
    private static byte[] getKeyBytes(String strKey) throws Exception {
        if (null == strKey || strKey.length() < 1) {
            throw new Exception("key is null or empty!");
        }
        byte[] bytes = strKey.getBytes(Charset.defaultCharset());
        int k = 0;
        int i = 0;
        byte[] bkey24 = new byte[24];
        for (i = 0; i < 24; i++) {
            if (k >= bytes.length) {
                bkey24[i] = 0;
                ;
            } else {
                bkey24[i] = bytes[k];
            }
            k++;
        }
        return bkey24;

    }

    /**
     * keybyte为加密密钥，长度为24字节
     * src为被加密的数据缓冲区（源）
     */
    private static byte[] encryptMode(byte[] keybyte, byte[] src) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //生成密钥
        SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM); //加密
        Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        c1.init(Cipher.ENCRYPT_MODE, deskey);
        return c1.doFinal(src);
    }

    /**
     * //keybyte为加密密钥，长度为24字节
     * //src为加密后的缓冲区
     *
     * @param keybyte
     * @param src
     * @return
     */
    private static byte[] decryptMode(byte[] keybyte, byte[] src) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //生成密钥
        SecretKey deskey = new SecretKeySpec(keybyte, ALGORITHM);
        //解密
        Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        c1.init(Cipher.DECRYPT_MODE, deskey);
        return c1.doFinal(src);
    }

    //转换成base64编码  
    private static String byte2Base64(byte[] b) {
        return Base64.encode(b);
    }

    //转换成十六进制字符串    
    private static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
            if (n < b.length - 1) {
                hs.append(":");
            }
        }
        return hs.toString().toUpperCase();
    }

}  