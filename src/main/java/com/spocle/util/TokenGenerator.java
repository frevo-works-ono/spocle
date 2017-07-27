package com.spocle.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class TokenGenerator {
	private static int TOKEN_LENGTH = 16; // 16*2=32バイト

	public static String generate() {
		byte token[] = new byte[TOKEN_LENGTH];
		StringBuilder buf = new StringBuilder();
		SecureRandom random = null;
		String tokenString = null;

		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			random.nextBytes(token);

			for (int i = 0; i < token.length; i++) {
				buf.append(String.format("%02x", token[i]));
			}
			tokenString = buf.toString();

			// System.out.println("String.format： " + tokenString);
			// System.out.println("DatatypeConverter： " +
			// DatatypeConverter.printHexBinary(token));

			return tokenString;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return "";
	}
}
