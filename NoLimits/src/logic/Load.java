package logic;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import data.Level;
import ui.window;

public abstract class Load {
	
	public static ArrayList<Level> initLvls(){
		
		ArrayList<Level> levels = new ArrayList<Level>();
		for(int i= 1; i<=9; i++) {
			Level level = new Level(i);
			levels.add(level);
		}
		return levels;
	}
	
	public static ImageIcon loadImg(String link) {
		ImageIcon img = new ImageIcon(window.class.getResource("/sources"+link));
		return img;
	}
	
	public static void loadIconsLvls(JPanel PLvls,ArrayList<Level> levels) {
		int lvlPlayer = Integer.parseInt(GameEngine.loadLevelPlayer());
		
		int pos[][] = {{155,522},{378,487},{605,438},{825,399},{1036,334},{843,267},{635,215},{430,161},{192,122}};
		
		for (int i= 0; i<=8; i++) {
			if(i+1 <= lvlPlayer) {
				levels.get(i).showIconE(PLvls, pos[i][0], pos[i][1]);
			}else {
				levels.get(i).showIconD(PLvls, pos[i][0], pos[i][1]);
			}
		}
	}
}