package logic;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import data.Enemie;
import data.Level;
import data.Player;
import ui.window;

public abstract class Load {
	
	public static ArrayList<Level> initLvls(){
		//Cargar enemigos
		ArrayList<Enemie> enemies = initEnemies();
		
		// Cargan las imagenes de los fondos de los niveles
		ArrayList<ImageIcon> bgs = new ArrayList<ImageIcon>(); 
		for(int i =1; i<=9; i++) {
			ImageIcon bg = loadImg("/backgrounds/levels/"+i+".jpg");
			bgs.add(bg);
		}
		
		//Instancian los niveles
		ArrayList<Level> levels = new ArrayList<Level>();
		for(int i= 1; i<=9; i++) {
			Level level = new Level(i, bgs.get(i-1), enemies.get(i-1));
			levels.add(level);
		}
		return levels;
	}
	
	public static ArrayList<Enemie> initEnemies() {
		//Cargan las imagenes de los enemigos
		ArrayList<ImageIcon> img_es = new ArrayList<ImageIcon>();
		for(int i =1; i<=9; i++) {
			ImageIcon img_e= loadImg("/enemies/"+i+".gif");
			img_es.add(img_e);
		}
		
		//Definir posicion predefinida de las imagenes de los enemigos 
		int pos[][] = {{900,300},{800,230},{800,300},{800,300},{670,200},{770,240},{800,200},{700,270},{750,200}};
		
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
		ImageIcon img = new ImageIcon(window.class.getResource("/sources"+link));
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
