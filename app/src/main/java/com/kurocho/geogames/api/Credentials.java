package com.kurocho.geogames.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Credentials {

    private String username;
    private String password;
    private String email;

    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Credentials(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    private String hashPassword(String password){
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            return bytesToHex(digest.digest());
        } catch (NoSuchAlgorithmException e1) {
            return password;
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
