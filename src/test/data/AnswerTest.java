package test.data;

import org.junit.Test;
import main.data.Answer;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class AnswerTest {
	@Test
	public void testHiddenAnswer() {
		String hiddenAnswer = Answer.getHiddenAnswer();
		char[] chars = new char[hiddenAnswer.length()];
		Arrays.fill(chars, '*');
		assertEquals(new String(chars), hiddenAnswer);
	}
}