package data;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ui.window;

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
	
	//-----Otros métodos------
	@Override
	public void showQuestion(JLabel boxQuestion, ImageIcon bg, Enemie enemie, Player player,  ArrayList<Question> questions, int iQuest) {
		
		JLabel lblText = new JLabel("Complete el código de la imagen:");
		lblText.setHorizontalAlignment(SwingConstants.LEFT);
		lblText.setFont(new Font("Txt_IV50", Font.PLAIN, 24));
		lblText.setVerticalAlignment(SwingConstants.CENTER);
		lblText.setBounds(10, 15, 893, 50);
		boxQuestion.add(lblText);
		
		JLabel question = new JLabel("");
		question.setIcon(this.getQuestionImg());
		question.setBounds(663, 10, this.getQuestionImg().getIconWidth(), this.getQuestionImg().getIconHeight());
		boxQuestion.add(question);
		
		JTextField answertxt = new JTextField("");
		answertxt.setFont(new Font("Txt_IV50", Font.PLAIN, 20));
		answertxt.setBounds(90, 70, 185, 40);
		answertxt.setColumns(10);
		boxQuestion.add(answertxt);
		
		JButton btnSend = new JButton("Enviar");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ansTxt = answertxt.getText();
				questions.get(iQuest).rightAnswer(bg, enemie, player, questions, ansTxt);
			}
		});
		btnSend.setFont(new Font("Txt_IV50", Font.PLAIN, 16));
		btnSend.setBounds(290, 70, 100, 40);
		boxQuestion.add(btnSend);
	}
	
	public void rightAnswer(ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions, String answer) {
		if(answer.equals(getRightAnswer())) {
			int vidaA = enemie.getLife();
			enemie.setLife(vidaA-60);
		}else {
			int vidaA = player.getLife();
			player.setLife(vidaA-60);
		}
		window.initializePlvl(bg, enemie, player, questions, this.getId());
	}
	
	public void rightAnswer(ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions,int idOption) {
	}
}
