package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import data.PDFSources;

/**
 * 
 * @author heathens
 * This class is a principal frame that contains a pdf viewer and a slider 
 * section
 *
 */

public class PDFViewer extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pdfContainer, buttonsContainer;
	private SwingController controller;
	private ButtonNBPDF next, before;
	private JLabel home;
	private JTree options;
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
		this.buttonsContainer = new JPanel(new BorderLayout());
		this.buttonsContainer.setBackground(new Color(230,230,230));
		this.next = next;
		this.before = before;
		this.buttonsContainer.add(this.before, BorderLayout.SOUTH);
		this.setUpHomeButton();
		this.buttonsContainer.add(this.home, BorderLayout.WEST);
		this.buttonsContainer.add(this.next, BorderLayout.NORTH);
		this.setUpIndexContainer();
		this.add(buttonsContainer,BorderLayout.WEST);
		this.setVisible(false);
		
		
		root.add(this);
	}
	
	public SwingController getController() {
		return this.controller;
	}
	
	public JLabel getHomeLabel() {
		return this.home;
	}
	
	public JTree getTree() {
		return this.options;
	}
	
	private void setUpHomeButton() {
		this.home = new JLabel();
		ClassLoader cl = this.getClass().getClassLoader();
		URL path = cl.getResource("sources/icons/home.png");
		ImageIcon iconButton = new ImageIcon(path);
		Image resizedIcon = iconButton.getImage();
		resizedIcon = resizedIcon.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		this.home.setIcon(new ImageIcon(resizedIcon));
	}
	
	private void setUpIndexContainer() {
		DefaultMutableTreeNode topTheme = new DefaultMutableTreeNode("NoLimits");
		DefaultMutableTreeNode specificTheme = new DefaultMutableTreeNode("POO con Java");
		topTheme.add(specificTheme);
		PDFSources namesPDF = new PDFSources();
		namesPDF.getPaths().stream().forEach(e -> {
			DefaultMutableTreeNode pdf = new DefaultMutableTreeNode(
					e.substring(0, e.length() - 4));
			specificTheme.add(pdf);
		});
		options = new JTree(topTheme);
		options.getSelectionModel().setSelectionMode(TreeSelectionModel.
				SINGLE_TREE_SELECTION);
		options.putClientProperty("JTree.lineStyle", "Angled");
		for (int i = 0; i < options.getRowCount(); i++) {
	         options.expandRow(i);
	    }
		this.buttonsContainer.add(options, BorderLayout.CENTER);
	}
}
