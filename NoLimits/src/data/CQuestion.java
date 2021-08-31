package data;

public class CQuestion extends Question {

	private String rightAnswer;
	
	//-----Constructor-----
	public CQuestion(int id, int level, String rightAnswer) {
		super(id, level);
		this.rightAnswer = rightAnswer;
	}
	

	//-----Getters and Setters-----
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
}
