package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public abstract class GameEngine {

	public static String loadLevelPlayer() {
		try {
			File file = new File("lvl.txt");
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			
			String lvl = br.readLine();
			reader.close();
			br.close();
			return lvl;
		}catch(Exception e) {
			writeFile("1");
			return "1";
		}
	}
	
	public static void writeFile(String lvl) {
		try {
			File file = new File("lvl.txt");
			FileWriter wr = new FileWriter(file, true);
			wr.write(lvl);
			wr.close();
		}catch(Exception e2) {
			System.out.println("Error en el pasillo logica tratando de cargar el archivo :p");
		}
	}
}
