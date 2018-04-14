package test.data;

import org.junit.Test;
import main.data.Password;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class PasswordTest {
	@Test
	public void testHiddenAnswer() {
		String hiddenAnswer = Password.getHiddenPassword();
		char[] chars = new char[hiddenAnswer.length()];
		Arrays.fill(chars, '*');
		assertEquals(new String(chars), hiddenAnswer);
	}
}