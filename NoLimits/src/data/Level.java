package data;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.GameEngine;
import logic.Load;

public class Level {
	private int id;
	private ImageIcon iconE;
	private ImageIcon iconD;
	private Enemie enemie;
	private ArrayList<Question> questions;
	
	public void showIconE(JPanel PLvls, int posX, int posY) {
		JLabel lblButton = new JLabel("");
		lblButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblButton.setIcon(this.iconE);
		lblButton.setBounds(posX, posY,  128, 86);
		PLvls.add(lblButton);
	}
	
	
	
	public void showIconD(JPanel PLvls, int posX, int posY) {
		JLabel lblButton = new JLabel("");
		lblButton.setIcon(this.iconD);
		lblButton.setBounds(posX, posY,  128, 86);
		PLvls.add(lblButton);
	}
	
	//------Constructors------
	public Level(int id, Enemie enemie, ArrayList<Question> questions) {
		this.id = id;
		this.iconE = Load.loadImg("/icons/lvlE.png");
		this.iconD = Load.loadImg("/icons/lvlD.png");
		this.enemie = enemie;
		this.questions = questions;
	}
	
	public Level(int id) {
		this(id, null, null);
	}
	
	//-----Getters and Setters-----
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ImageIcon getIconE() {
		return iconE;
	}

	public void setIconE(ImageIcon iconE) {
		this.iconE = iconE;
	}

	public ImageIcon getIconD() {
		return iconD;
	}

	public void setIconD(ImageIcon iconD) {
		this.iconD = iconD;
	}

	public Enemie getEnemie() {
		return enemie;
	}

	public void setEnemie(Enemie enemie) {
		this.enemie = enemie;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
}
