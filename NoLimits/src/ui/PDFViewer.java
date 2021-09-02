package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 * 
 * @author heathens
 * This class is a principal frame that contains a pdf viewer and a slider 
 * section
 *
 */

public class PDFViewer extends JPanel{
	
	private JPanel pdfContainer, buttonsContainer;
	private SwingController controller;
	private ButtonNBPDF next, before;
	private JLabel home;
	
	public PDFViewer(JFrame root, ButtonNBPDF next, ButtonNBPDF before
			,int width, int height) {
		super(new BorderLayout(10, 10));
		this.setBounds(0,0,width, height);
		
		//An instance of SwingController to manage pdfViewer
		this.controller = new SwingController();
		
		// Build a SwingViewFactory configured with the controller
		SwingViewBuilder factory = new SwingViewBuilder(this.controller);

		// Use the factory to build a JPanel that is pre-configured
		//with a complete, active Viewer UI.
		this.pdfContainer = factory.buildViewerPanel();
		this.add(this.pdfContainer, BorderLayout.CENTER);
		
		//Create and set up slider frame
		this.buttonsContainer = new JPanel();
		this.buttonsContainer.setBackground(new Color(173,216,230));
		this.next = next;
		this.before = before;
		this.buttonsContainer.add(this.before);
		this.setUpHomeButton();
		this.buttonsContainer.add(this.home);
		this.buttonsContainer.add(this.next);
		this.add(buttonsContainer,BorderLayout.SOUTH);
		this.setVisible(false);
		
		root.add(this);
	}
	
	public SwingController getController() {
		return this.controller;
	}
	
	public JLabel getHomeLabel() {
		return this.home;
	}
	
	private void setUpHomeButton() {
		this.home = new JLabel();
		ImageIcon iconButton = new ImageIcon("src/sources/icons/home.png");
		Image resizedIcon = iconButton.getImage();
		resizedIcon = resizedIcon.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		this.home.setIcon(new ImageIcon(resizedIcon));
	}
}
