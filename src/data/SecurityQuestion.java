package data;

public class SecurityQuestion {
	private String question;
	private Answer answer;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getHiddenAnswer() {
		return answer.getHiddenAnswer();
	}
	
	public String getRealAnswer() {
		return answer.getRealAnswer();
	}
	
	public void setAnswer(String answer) {
		this.answer = new Answer(answer);
	}
}