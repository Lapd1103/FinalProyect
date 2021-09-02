package ui;

import javax.swing.Icon;
import javax.swing.JButton;

/*
 * This class will be used as a slider to go next or before
 * pdf file
 */
public class ButtonNBPDF extends JButton{
	
	public static int pointerPDF;
	public ButtonNBPDF(Icon icon, int x, int y, int pointer) {
		super(icon);
	}
	public int getPointerPDF() {
		return pointerPDF;
	}
	public void setPointerPDF(int pointerPDF) {
		this.pointerPDF = pointerPDF;
	}
	
	

}
