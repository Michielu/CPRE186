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
		//Go to level 1 state
		if((xPos>225 && xPos<300) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(21);
			}
		}
		//Go to level 2 state
		if((xPos>367 && xPos<430) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(22);
			}
		}
		//Go to level 3 state
		if(!input.isMouseButtonDown(0)){
			Play.canGoOn= true;
		}
		if(Play.canGoOn&&(xPos>507 && xPos<575) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				Play.canGoOn = false;
				sbg.enterState(23);
			}
		}
		//Go to level 4 state
		if((xPos>645 && xPos<715) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
			
				sbg.enterState(24);
			}
		}
		//Go to level 5 state
		if((xPos>786 && xPos<860) && (yPos<470 && yPos > 400)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(25);
			}
		}
	}
	
	
	public int getID(){
		return 20;
	}
}

