package main.data;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Password {
	private String password;
	
	public Password(String p) {
		password = p;
	}

	public static String getHiddenPassword() {
		// return randomized hidden password
		// do not give any hint as to the length of the password
		// TODO : clean up this string generation for password
		int randomPasswordLength = (new Random()).nextInt(20);
		char[] text = new char[randomPasswordLength];
		for (int i = 0; i < randomPasswordLength; ++i) {
			text[i] = '*';
		}
		return new String(text);
	}

	public String retrieveRealPassword() {
		return password;
	}
}
