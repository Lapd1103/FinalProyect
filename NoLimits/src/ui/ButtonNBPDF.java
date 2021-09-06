package ui;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author heathens
 * This class will be used as a slider to go next or before
 * pdf file
 * 
 */
public class ButtonNBPDF extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int pointerPDF;

	public ButtonNBPDF(String nameImage) {
		super();
		//Scale the image and put it like icon button
		ClassLoader cl = this.getClass().getClassLoader();
		URL path = cl.getResource("sources/icons/" + nameImage); 
		ImageIcon iconButton = new ImageIcon(path);
		Image resizedIcon = iconButton.getImage();
		resizedIcon = resizedIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(resizedIcon));
		
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setBackground(new Color(230,230,230));
	}
}
