package data;

import javax.swing.ImageIcon;

public class CQuestion extends Question {

	private ImageIcon questionImg;
	private String rightAnswer;
	
	
	//-----Constructor-----
	public CQuestion(int id, int level, ImageIcon questionImg, String rightAnswer) {
		super(id, level);
		this.questionImg = questionImg;
		this.rightAnswer = rightAnswer;
	}
	

	//-----Getters and Setters-----
	
	public ImageIcon getQuestionImg() {
		return questionImg;
	}

	public void setQuestionImg(ImageIcon questionImg) {
		this.questionImg = questionImg;
	}
	
	public String getRightAnswer() {
		return rightAnswer;
	}
	
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
}
