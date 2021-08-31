package data;

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
	
	
}
