package data;

import javax.swing.ImageIcon;

public class Enemie {
	private int id;
	private ImageIcon img;
	private int life;

	//-----Constructor-----
	public Enemie(int id, ImageIcon img, int life) {
		this.id = id;
		this.img = img;
		this.life = life;
	}
	
	//-----Getters and Setters-----
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
