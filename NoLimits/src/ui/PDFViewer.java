package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
//This is the panel where the pdf viewer is located and the buttons
public class PDFViewer extends JPanel{
	
	JPanel pdfContainer, buttonsContainer;
	SwingController controller;
	ButtonNBPDF next, before;
	
	public PDFViewer(JFrame root, ButtonNBPDF next, ButtonNBPDF before
			,int width, int height) {
		super();
		this.setBounds(0,0,width, height);
		this.setLayout(new BorderLayout(10, 10));
		this.controller = new SwingController();
		root.add(this);

		// Build a SwingViewFactory configured with the controller
		SwingViewBuilder factory = new SwingViewBuilder(this.controller);

		// Use the factory to build a JPanel that is pre-configured
		//with a complete, active Viewer UI.
		this.pdfContainer = factory.buildViewerPanel();
		this.add(this.pdfContainer, BorderLayout.CENTER);
		this.next = next;
		this.buttonsContainer = new JPanel();
		this.before = before;
		this.buttonsContainer.add(before);
		this.buttonsContainer.add(next);
		
		this.add(buttonsContainer,BorderLayout.SOUTH);
	
		//this.controller.openDocument("src/sources/pdfs/3.Herencia.pdf");
		this.controller.setZoom(2.51f);
	}
	
	public SwingController getController() {
		return this.controller;
	}
}
