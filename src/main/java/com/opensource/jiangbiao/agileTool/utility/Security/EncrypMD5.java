package com.opensource.jiangbiao.agileTool.utility.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by p2vdug on 9/24/2017.
 */
public class EncrypMD5 {
    public static String encrypt(String info) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] srcBytes = info.getBytes();
            md5.update(srcBytes);


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("MessageDiagest Error");
        }
        byte[] resultBytes = md5.digest();
        return new String(resultBytes);
    }

//    public static void main(String[] args){
//        String msg = "2131554887";
//        EncrypeMD5 md5 = new EncrypeMD5();
//        System.out.println(msg);
//        System.out.println(EncrypeMD5.encrypt(msg));
//
//    }
}
