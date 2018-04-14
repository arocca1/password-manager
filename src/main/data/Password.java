package main.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Password extends CredentialSecret {
	public Password(String p) {
		secret = p;
	}

	public static String getHiddenPassword() {
		return getHiddenSecret();
	}

	public String retrieveRealPassword() {
		return secret;
	}
}
