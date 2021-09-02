package logic;

import org.icepdf.ri.common.SwingController;

import data.PDFSources;
import ui.ButtonNBPDF;

public class ManagePDF {
	public static void addDataEventsNext(ButtonNBPDF next, PDFSources paths, SwingController controller) {
		next.addActionListener(e->{
			if(ButtonNBPDF.pointerPDF != paths.getPaths().size() - 1) {
				controller.openDocument("src/sources/pdfs/" + paths.getPaths().get(next.getPointerPDF() + 1));
				ButtonNBPDF.pointerPDF += 1;
			}
			
		});
	}
	
	
	public static void addDataEventsBefore(ButtonNBPDF next, PDFSources paths, SwingController controller) {
		next.addActionListener(e->{
			if(ButtonNBPDF.pointerPDF != 0) {
				controller.openDocument("src/sources/pdfs/" + paths.getPaths().get(next.getPointerPDF() - 1));
				ButtonNBPDF.pointerPDF -= 1;
			}
			
		});
	}
}
