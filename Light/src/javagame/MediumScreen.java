package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class MediumScreen extends BasicGameState{
	public String mouse = "No input yet";
	
	Image mediumLevels;
	public MediumScreen(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		mediumLevels = new Image("res/menus/medium_levels(1080x720).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		mediumLevels.draw(0,0);
		g.drawString(mouse, 50, 50);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
		
		Input input = gc.getInput();
		//Enter play state
		if((xPos>460 && xPos<625) && (yPos<280 && yPos > 245)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}
	}
	
	
	public int getID(){
		return 20;
	}
}

