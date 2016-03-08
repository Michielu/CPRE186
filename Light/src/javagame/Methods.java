package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;


public class Methods extends BasicGameState {
	public static Image blankTile;

	public Methods(int state){ 
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		blankTile = new Image("res/tile/blank_tile(70x70).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{

	}
	
	

	public static void blankTiles() throws SlickException{
		int xStart = 260;
		int yStart = 80;
		int i =0;
		int j = 0;
		for(i=0;i<8;i++){
			for(j=0; j<8;j++){
				blankTile.draw(xStart, yStart);
				yStart = yStart + 70;
			}
			xStart = xStart + 70;
			yStart = 80;
		}
	}
	
	public int getID(){
		return 100;
	}

}
