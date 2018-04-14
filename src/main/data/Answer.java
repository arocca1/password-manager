package main.data;

public class Answer extends CredentialSecret {
	public Answer(String a) {
		secret = a;
	}

	public static String getHiddenAnswer() {
		return getHiddenSecret();
	}

	public String getRealAnswer() {
		return secret;
	}

	public void setAnswer(String a) {
		secret = a;
	}
}
