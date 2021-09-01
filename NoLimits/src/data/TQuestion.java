package data;

import java.util.ArrayList;

public class TQuestion extends Question{
	private String question;
	private ArrayList<Option> options;
	private int answerId;
	
	
	//----Constructors-----
	public TQuestion(int id, int level, String question, ArrayList<Option> options, int answerId) {
		super(id, level);
		this.question = question;
		this.options = options;
		this.answerId = answerId;
	}

	public TQuestion(int id, int level) {
		super(id, level);
	}
	
	//-----Getters and Setters----
	
	public ArrayList<Option> getOptions() {
		return options;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	@Override
	public String toString() {
		return "Id: "+this.getId()+"\nLevel: "+this.getLevel()+"\nPregunta: "+this.question+"\noptions: "+this.getOptions()+"\n Respuesta correcta: "+this.getAnswerId();
	}
	
	
	
}
