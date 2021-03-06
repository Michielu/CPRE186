package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.newdawn.slick.Image;
import org.lwjgl.input.Mouse;


//Every screen inherits from BasicGameState. Extends = inherits
public class Menu extends BasicGameState{	
	Image mainMenu;
	public String mouse = "No input yet";
	/*
	 * int state is the ID number of the state 
	 * for menu, it was (0)
	 * Constructor 
	 */
	public Menu(int state){ 
		
	}
	
	/*
	 * Built into Slick2D. Helps initialize crap it needs
	 * init = initial value 
	 */
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		mainMenu = new Image("res/menus/main_menu(1080x720).png");
	}
	
	/*
	 * Draws stuff on a screen
	 * Graphics is like a paintbrush that paints everything we want it to
	 * Graphics are always named g
	 * g. has some built in methods - look up graphic 2d on java API page
	 * Need a variable bc a static string is never going to change. Variables will change
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {		
		mainMenu.draw(0, 0);
		g.drawString(mouse, 50, 50);
	}//just checking
	
	/*
	 * Update: updates image on screen - 
	 * If we want animation, we need the screen to update
	 * When things change
	 * Java already knows where the mouse is on the system. We need to
	 * retrieve it from java and put it in a variable.
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
		
		Input input = gc.getInput();
		  
		//This checks to see if the mouse is in the circle
		if((xPos>470 && xPos<600) && (yPos<475 && yPos > 425)){
			//This checks to see if the mouse button is down
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}
		 //Credits button
		  if((xPos >425&& xPos<655)&& (yPos>287 && yPos < 325)){
			  if(input.isMouseButtonDown(0)){
				  sbg.enterState(2);
			  }
		  }
		  //Exit button
		  if((xPos >480&& xPos<590)&& (yPos>150 && yPos < 195)){
			  if(input.isMouseButtonDown(0)){
				  System.exit(0);
			  }
		  }
	}
	
	/*
	 * Returns the state of the game
	 * This returns 0 bc the Menu's screen ID is 0
	 */
	public int getID(){
		return 0;
	}
}
