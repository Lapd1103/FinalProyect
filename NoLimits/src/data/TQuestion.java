package data;

import java.util.ArrayList;

public class TQuestion extends Question{
	private ArrayList<Option> options;
	private int answerId;
	
	
	//----Constructors-----
	public TQuestion(int id, int level, ArrayList<Option> options, int answerId) {
		super(id, level);
		this.options = options;
		this.answerId = answerId;
	}

	public TQuestion(int id, int level) {
		super(id, level);
	}
	
	//-----Getters and Setters-----
	public ArrayList<Option> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	
	
}
