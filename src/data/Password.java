package data;

import java.util.Random;

public class Password {
	private String password;
	
	public Password(String p) {
		password = p;
	}

	public String getHiddenPassword() {
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

	public String getRealPassword() {
		return password;
	}
}
