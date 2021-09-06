package data;

import java.util.ArrayList;
/**
 * 
 * @author heathens
 *
 * Class that contains all paths to source/PDFs and acts like a wrapper of
 * paths
 */
public class PDFSources {
	private ArrayList<String> paths;


	public PDFSources() {
		this.paths = new ArrayList<>();
		this.paths.add("1.Principios de POO.pdf");
		this.paths.add("2.Encapsulamiento.pdf");
		this.paths.add("3.Herencia.pdf");
		this.paths.add("4.Abstracción.pdf");
		this.paths.add("5.Polimorfismo.pdf");
		this.paths.add("6.Colecciones.pdf");
		this.paths.add("7.Interfaz Gráfica.pdf");
		this.paths.add("8.Programación multihilo.pdf");
		this.paths.add("9.Excepciones.pdf");
	}

	public ArrayList<String> getPaths() {
		return this.paths;
	}

	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}
	
	
}
