package logic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.icepdf.ri.common.SwingController;

import data.PDFSources;
import ui.ButtonNBPDF;

/**
 * 
 * @author heathens
 * Here add events to buttons and manage that going to show the pdfViewer frame
 * using the SwingController
 */
public class ManagePDF {
	public static void addDataEventsNext(ButtonNBPDF next, PDFSources paths, SwingController controller) {
		next.addActionListener(e->{
			if(ButtonNBPDF.pointerPDF != paths.getPaths().size() - 1) {
				controller.openDocument("src/sources/PDFs/" + paths.getPaths().get(ButtonNBPDF.pointerPDF + 1));
				ButtonNBPDF.pointerPDF += 1;
				controller.setZoom(2.24f);
			}
			
		});
	}
	
	
	public static void addDataEventsBefore(ButtonNBPDF next, PDFSources paths, SwingController controller) {
		next.addActionListener(e->{
			if(ButtonNBPDF.pointerPDF != 0) {
				controller.openDocument("src/sources/PDFs/" + paths.getPaths().get(ButtonNBPDF.pointerPDF - 1));
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
}
