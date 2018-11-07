package com.dexfun.yiku.utils;


import android.util.Base64;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSACryptography {

    public static String data = "hello world";

    public static void main(String[] args) throws Exception {

//        KeyPair keyPair = genKeyPair(1024);
//
//        //获取公钥，并以base64格式打印出来
//        PublicKey publicKey = keyPair.getPublic();
//        System.out.println("公钥：" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));
//
//        //获取私钥，并以base64格式打印出来
//        PrivateKey privateKey = keyPair.getPrivate();
//        System.out.println("私钥：" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));
//
//        //公钥加密
//        byte[] encryptedBytes = encrypt(data.getBytes(), publicKey);
//        System.out.println("加密后：" + new String(encryptedBytes));
//
//        //私钥解密
//        byte[] decryptedBytes = decrypt(encryptedBytes, privateKey);
//        System.out.println("解密后：" + new String(decryptedBytes));
    }

    //生成密钥对
    public static KeyPair genKeyPair(int keyLength) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA",
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());
        keyPairGenerator.initialize(keyLength);
        return keyPairGenerator.generateKeyPair();
    }

    //将base64编码后的公钥字符串转成PublicKey实例
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        byte[] keyBytes = Base64.decode(publicKey.getBytes(), Base64.DEFAULT);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    //将base64编码后的私钥字符串转成PrivateKey实例
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        byte[] keyBytes = Base64.decode(privateKey.getBytes(), Base64.DEFAULT);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA",
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());
        return keyFactory.generatePrivate(keySpec);
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA",
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    public static String encryptPhone(String phone) throws Exception {
        String e = new String(Base64.encode(RSACryptography.encrypt(phone.getBytes(), RSACryptography.getPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBC5T7S0hhZKF7ri5xV3R0ebGyeXT8fZIgxSbIAI+7MVwxfnL+qOYYqnX3V6BJDw87OEnGcFV2DLcqahUb691XnvS6FQI8kAlL9Xcc5NLKJmxD3GOlxlFpobCNHcCUiyf1TdVOUoSh9Dh2NK1UOiY2YdzllkEAH88Ji03xzvv4XwIDAQAB")), Base64.NO_WRAP));
        System.out.println(e);
        return e;
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA",
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }

}
