package data;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ui.window;

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
	
	//-----Otros métodos------
	public void showQuestion(JLabel boxQuestion, ImageIcon bg, Enemie enemie, Player player,  ArrayList<Question> questions, int iQuest) {
		JLabel lblQuestion = new JLabel(this.getQuestion());
		lblQuestion.setFont(new Font("Txt_IV50", Font.PLAIN, 24));
		lblQuestion.setVerticalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(10, 10, 1346, 50);
		boxQuestion.add(lblQuestion);
		
		for(int i= 0; i<=3; i++) {
			this.getOptions().get(i).showOption(boxQuestion, bg, enemie, player,  questions, iQuest);
		}
	}
	
	public void rightAnswer(ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions,int idOption) {
		if(idOption == this.getAnswerId()) {
			int vidaA = enemie.getLife();
			enemie.setLife(vidaA-60);
		}
		else{
			int vidaA = player.getLife();
			player.setLife(vidaA-60);
		}
		
		window.initializePlvl(bg, enemie, player, questions, this.getId());
	}
	
	public void rightAnswer(ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions, String answer) {
		
	};
	
}
