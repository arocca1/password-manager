package test.data;

import org.junit.Test;
import main.data.CredentialSecret;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class CredentialSecretTest {
	@Test
	public void testHiddenSecret() {
		String hiddenAnswer = CredentialSecret.getHiddenSecret();
		char[] chars = new char[hiddenAnswer.length()];
		Arrays.fill(chars, '*');
		assertEquals(new String(chars), hiddenAnswer);
	}
}