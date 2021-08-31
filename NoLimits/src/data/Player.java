package data;

import javax.swing.ImageIcon;

public class Player {
	private ImageIcon img;
	private int life;
	
	//-----Constructor-----
	public Player(ImageIcon img, int life) {
		this.img = img;
		this.life = life;
	}
	
	//-----Getters and Setters-----
	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
