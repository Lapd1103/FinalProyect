package data;

import javax.swing.ImageIcon;

public class Enemie {
	private int id;
	private int life;
	private ImageIcon img;
	private int posX;
	private int posY;
	
	//-----Constructor-----
	public Enemie(int id, int life, ImageIcon img, int posX, int posY) {
		this.id = id;
		this.life = life;
		this.img = img;
		this.posX = posX;
		this.posY = posY;
	}
	
	//-----Getters and Setters-----
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
