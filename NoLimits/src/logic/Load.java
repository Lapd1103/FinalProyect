package logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import data.CQuestion;
import data.Enemie;
import data.Level;
import data.Option;
import data.Player;
import data.Question;
import data.TQuestion;
import ui.window;

public abstract class Load {
	
	@SuppressWarnings("finally")
	public static ArrayList<Level> initLvls(){
		ArrayList<Level> levels = new ArrayList<Level>();
		try {
		//Cargar enemigos 
		ArrayList<Enemie> enemies = initEnemies();
		//Cargar jugador
		Player player = initPlayer();
		
		//Instancia de los niveles
		levels = new ArrayList<Level>();
		for(int i= 1; i<=9; i++) {
			//cargar preguntas
			ArrayList<Question> questions = initQuestions(i);
			
			// Cargan las imagenes de los fondos de los niveles
			ImageIcon bg = loadImg("/backgrounds/levels/"+i+".jpg");
			
			//Instancia del nivel
			Level level = new Level(i, bg, enemies.get(i-1), player, questions);
			levels.add(level);
		}
		return levels;
		}
		catch(Exception e) {
			
		}
		finally {
			return levels;
		}
	}
	
	@SuppressWarnings("finally")
	public static ArrayList<Question> initQuestions(int lvl) {
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
		//Cargar preguntas teoricas
		ArrayList<TQuestion> tQuestions = initTQuestions(lvl);
		ArrayList<CQuestion> cQuestions = initCQuestions(lvl);
		
		questions = new ArrayList<Question>();
		for(int i = 0; i<=2; i++) {
			questions.add(tQuestions.get(i));
		}
		for(int i = 0; i<=1; i++) {
			questions.add(cQuestions.get(i));
		}
		return questions;
		}
		catch(Exception e) {
			
		}
		finally {
			return questions;
		}
	}

	public static ArrayList<CQuestion> initCQuestions(int lvl){
		ArrayList<CQuestion> cQuestions = new ArrayList<CQuestion>();
		//Respuestas de preguntas teoricas
		String ask[][] = {{"public","new"},{"private","getNombre"},{"extends","super"},{"extends","interface"},{"abstract","static"},{"String","listaCompras"},{"JLabel","Font"},{"extends","implements"},{"try","Exception"}};
		
		for(int i = 1; i<=2; i++) {
			CQuestion cquest = new CQuestion(i+3, lvl, loadImg("/questions/C/"+lvl+i+".png"), ask[lvl-1][i-1]);
			cQuestions.add(cquest);
		}
		return cQuestions;
	}
	
	public static ArrayList<TQuestion> initTQuestions(int lvl){
		ArrayList<TQuestion> tQuestions = new ArrayList<TQuestion>();
		try {
			InputStream file =  Load.class.getClassLoader().getResourceAsStream("sources/questions/T/"+lvl+".txt");
			InputStreamReader reader = new java.io.InputStreamReader(file);
			BufferedReader br = new BufferedReader(reader);
			
			for(int i = 1; i<=3; i++) {
				int answerId = 0;
				ArrayList<Option> options = new ArrayList<Option>();
				String question = br.readLine();
				
				for(int j=1; j<=4; j++) {
					String op = br.readLine();
					if(op.startsWith("*")) {
						answerId = j; 
						String opc = op.replace("*", "");
						options.add(new Option(j, opc));
					}else {
						options.add(new Option(j, op));
					}
				}
				TQuestion Tq = new TQuestion(i, lvl, question,options, answerId);
				tQuestions.add(Tq);
				
				br.readLine(); //Linea de espacio entre preguntas
			}
			reader.close();
			br.close();
		}catch(Exception e) {
			System.out.println("Error tratando de cargar las preguntas teoricas"+e);
			System.out.println(e.getMessage() + e.getLocalizedMessage());
		}
	
		return tQuestions;
	}
	
	public static ArrayList<Enemie> initEnemies() {
		//Cargan las imagenes de los enemigos
		ArrayList<ImageIcon> img_es = new ArrayList<ImageIcon>();
		for(int i =1; i<=9; i++) {
			ImageIcon img_e= loadImg("/enemies/"+i+".gif");
			img_es.add(img_e);
		}
		
		//Definir posicion predefinida de las imagenes de los enemigos 
		int pos[][] = {{900,220},{800,150},{800,220},{800,220},{670,165},{770,160},{800,120},{700,190},{750,120}};
		
		//Instanciar los enemigos
		ArrayList<Enemie> enemies = new ArrayList<Enemie>();
		for(int i= 1; i<=9; i++) {
			Enemie enemie = new Enemie(i, 305, img_es.get(i-1), pos[i-1][0], pos[i-1][1]);
			enemies.add(enemie);
		}
		return enemies;
	}
	
	public static Player initPlayer() {
		//Cargar imagen del jugador 
		ImageIcon img_player = loadImg("/player/player.gif");
		
		Player player = new Player(img_player, 305);
		return player;
	}
	
	public static ImageIcon loadImg(String link) {
		ImageIcon img = new ImageIcon(window.class.getClassLoader().getResource("sources"+link));
		return img;
	}
	
	public static void loadIconsLvls(JPanel PLvls, JPanel PLvl, ArrayList<Level> levels) {
		int lvlPlayer = Integer.parseInt(GameEngine.loadLevelPlayer());
		
		int pos[][] = {{155,522},{378,487},{605,438},{825,399},{1036,334},{843,267},{635,215},{430,161},{192,122}};
		
		for (int i= 0; i<=8; i++) {
			if(i+1 <= lvlPlayer) {
				levels.get(i).showIconE(PLvls, PLvl, pos[i][0], pos[i][1]);
			}else {
				levels.get(i).showIconD(PLvls, pos[i][0], pos[i][1]);
			}
		}
	}
}
