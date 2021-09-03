package data;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Question {
	private int id;
	private int level;
	
	//-----Constructor-----
	public Question(int id, int level) {
		this.id = id;
		this.level = level;
	}

	
	//-----Getters and Setters-----
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	//-----Métodos abstractos------
	public abstract void showQuestion(JLabel boxQuestion, ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions, int iQues);

	public abstract void rightAnswer(ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions, String answer);
	public abstract void rightAnswer(ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions,int idOption);
}
