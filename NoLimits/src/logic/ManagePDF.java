package logic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.icepdf.ri.common.SwingController;

import data.PDFSources;
import ui.ButtonNBPDF;

/**
 * 
 * @author heathens Here add events to buttons and manage that going to show the
 *         pdfViewer frame using the SwingController
 */
public class ManagePDF {
	public static void addDataEventsNext(ButtonNBPDF next, PDFSources paths, SwingController controller) {
		next.addActionListener(e -> {
			if (ButtonNBPDF.pointerPDF != paths.getPaths().size() - 1) {
				ClassLoader cl = new ManagePDF().getClass().getClassLoader();
				URL path = cl.getResource("sources/PDFs/" + paths.getPaths().get(ButtonNBPDF.pointerPDF + 1));
				controller.openDocument(path);
				ButtonNBPDF.pointerPDF += 1;
				controller.setZoom(2.24f);
			}

		});
	}

	public static void addDataEventsBefore(ButtonNBPDF next, PDFSources paths, SwingController controller) {
		next.addActionListener(e -> {
			if (ButtonNBPDF.pointerPDF != 0) {
				ClassLoader cl = new ManagePDF().getClass().getClassLoader();
				URL path = cl.getResource("sources/PDFs/" + paths.getPaths().get(ButtonNBPDF.pointerPDF - 1));
				controller.openDocument(path);
				ButtonNBPDF.pointerPDF -= 1;
				controller.setZoom(2.24f);
			}

		});
	}

	public static void addEventHomeLabel(JPanel toShow, JPanel toHide, JLabel home) {
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toHide.setVisible(false);
				toShow.setVisible(true);
			}
		});
	}

	public static void addListenerJTree(JTree options, SwingController controller) {

		// Listen for when the selection changes.
		options.addTreeSelectionListener(e -> {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) options.getLastSelectedPathComponent();
			if (node != null && node.isLeaf()) {
				ClassLoader cl = new ManagePDF().getClass().getClassLoader();
				URL path = cl.getResource("sources/PDFs/" + node.toString() + ".pdf");
				controller.openDocument(path);
				ButtonNBPDF.pointerPDF = Character.getNumericValue(node.toString().charAt(0)) - 1;
				controller.setZoom(2.24f);
			}

		});

	}
}
