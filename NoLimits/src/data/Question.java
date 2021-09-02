package data;

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
	public abstract void showQuestion(JLabel boxQuestion);
}
