package com.epam.rd.java.basic.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

    public static void main(String[] args) {
        //Empty

    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder res=new StringBuilder();
        for (byte b : hash) {
            if (b > 0) {
                if (b < 16) {
                    res.append("0").append(Integer.toHexString(b).toUpperCase());
                } else {
                    res.append(Integer.toHexString(b).toUpperCase());
                }
            } else {
                res.append(Integer.toHexString(256 + b).toUpperCase());
            }
        }
        return res.toString();
    }
}
