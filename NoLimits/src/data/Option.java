package data;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Option {
	private int id;
	private String text;
	
	//-----Constructor-----
	public Option(int id, String text) {
		this.id = id;
		this.text = text;
	}
	//-----Getters and Setters-----

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	//-----toString-----
	@Override
	public String toString() {
		return "Opcion "+this.id+": "+this.text;
	}
	
	//-----otros Métodos-----
	public void showOption(JLabel boxQuestion,ImageIcon bg, Enemie enemie, Player player, ArrayList<Question> questions, int iQuest) {
		
		
		JButton btnOption = new JButton(this.getText());
		btnOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				questions.get(iQuest).rightAnswer(bg, enemie, player,  questions, getId());
			}
		});
		btnOption.setVerticalAlignment(SwingConstants.CENTER);
		btnOption.setFont(new Font("Txt_IV50", Font.PLAIN, 16));
		btnOption.setBounds((73*this.id)+(250*(this.id-1)), 85, 250, 65);
		boxQuestion.add(btnOption);
	}
}
