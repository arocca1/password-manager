package main.data;

import java.util.Random;

public abstract class CredentialSecret {
	protected String secret;

	public static String getHiddenSecret() {
		int randomPasswordLength = (new Random()).nextInt(20);
		char[] text = new char[randomPasswordLength];
		for (int i = 0; i < randomPasswordLength; ++i) {
			text[i] = '*';
		}
		return new String(text);
	}
}
