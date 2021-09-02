package logic;

import org.icepdf.ri.common.SwingController;

import data.PDFSources;
import ui.ButtonNBPDF;

public class ManagePDF {
	public static void addDataEventsNext(ButtonNBPDF next, PDFSources paths, SwingController controller) {
		next.addActionListener(e->{
			if(next.getPointerPDF() != 3) {
				controller.openDocument("src/sources/pdfs/" + paths.getPaths().get(next.getPointerPDF() + 1));
				next.setPointerPDF(next.getPointerPDF() + 1);
			}
			
		});
	}
}
