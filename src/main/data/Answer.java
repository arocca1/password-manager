package main.data;

import java.util.Random;

public class Answer {
	private String answer;

	public Answer(String a) {
		this.answer = a;
	}

	public String getHiddenAnswer() {
		// return randomized hidden answer
		// do not give any hint as to the length of the answer
		// TODO : clean up this string generation for answer
		int randomAnswerLength = (new Random()).nextInt(20);
		char[] text = new char[randomAnswerLength];
		for (int i = 0; i < randomAnswerLength; ++i) {
			text[i] = '*';
		}
		return new String(text);
	}

	public String getRealAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
