package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy2 extends BasicGameState{
	Image background;
	public Easy2(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		background = new Image("res/backgrounds/puzzle_background1(1080x720).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Methods.currentStateNum = 12;
		background.draw(0, 0);
		Methods.blankTiles();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		Input input = gc.getInput();
		//Go to Menu state
		if((xPos>890 && xPos<1074) && (yPos<720 && yPos > 655)){
			if(input.isMouseButtonDown(0)){
				Play.canGoOn = false;
				sbg.enterState(0);
			}
		}
		
		if((xPos<311 && xPos>279)&&(yPos>16&&yPos<61)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(11);
			}
		}
	}
	
	
	public int getID(){
		return 12;
	}
}
