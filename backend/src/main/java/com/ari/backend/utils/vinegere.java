package com.ari.backend.utils;

import java.util.Base64;

public class vinegere {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String encrypt(String input, String key) {
        int keyLength = key.length();
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int plainTextCharIndex = alphabet.indexOf(input.charAt(i));
            int keyCharIndex = alphabet.indexOf(key.charAt(i % keyLength));
            int encryptedCharIndex = (plainTextCharIndex + keyCharIndex) % alphabet.length();
            encryptedText.append(alphabet.charAt(encryptedCharIndex));
        }
        return Base64.getEncoder().encodeToString(encryptedText.toString().getBytes());
    }

    public static String decrypt(String encryptedText, String key) {
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        String decryptedText = new String(decodedBytes);
        int keyLength = key.length();
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < decryptedText.length(); i++) {
            int decryptedTextCharIndex = alphabet.indexOf(decryptedText.charAt(i));
            int keyCharIndex = alphabet.indexOf(key.charAt(i % keyLength));
            int plainTextCharIndex = (decryptedTextCharIndex - keyCharIndex + alphabet.length()) % alphabet.length();
            plainText.append(alphabet.charAt(plainTextCharIndex));
        }
        return plainText.toString();
    }
}
