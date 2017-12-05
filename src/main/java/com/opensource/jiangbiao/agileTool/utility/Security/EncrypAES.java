package com.opensource.jiangbiao.agileTool.utility.Security;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

/**
 * Created by p2vdug on 9/24/2017.
 */
public class EncrypAES {
    //KeyGenerator 提供对称密钥生成器的功能，支持各种算法
    private KeyGenerator keygen;
    //SecretKey 负责保存对称密钥
    private  SecretKey deskey;
    //Cipher负责完成加密或解密工作
    private Cipher c;
    //该字节数组负责保存加密的结果
    private byte[] cipherByte;

    private String secretKey = "jiangbiao";


    public EncrypAES(){
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        try {
            keygen = KeyGenerator.getInstance("AES");
            keygen.init(128,new SecureRandom(secretKey.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //生成密钥
        deskey = keygen.generateKey();

        //生成Cipher对象,指定其支持的DES算法
        try {
            c = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对字符串加密
     *
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String Encrytor(String str) {
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        try {
            c.init(Cipher.ENCRYPT_MODE, deskey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        byte[] src = str.getBytes();
        // 加密，结果保存进cipherByte
        try {
            cipherByte = c.doFinal(src);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return StringToByteArray.parseByte2HexStr(cipherByte);
    }

    /**
     * 对字符串解密
     *
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String Decryptor(String decontent)  {
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
        byte[] buff = StringToByteArray.parseHexStr2Byte(decontent);
        try {
            c.init(Cipher.DECRYPT_MODE, deskey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        try {
            cipherByte = c.doFinal(buff);
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return new String(cipherByte);
    }

    /**
     * @param args
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    public static void main(String[] args)  {
        EncrypAES de1 = new EncrypAES();
        EncrypAES de2 = new EncrypAES();
        String msg ="jiangbiao";
        String encontent = de1.Encrytor(msg);
        String decontent = de2.Decryptor(encontent);
        System.out.println("明文是:" + msg);
        System.out.println("加密后:" + encontent);
        System.out.println("解密后:" + decontent);
    }
}
