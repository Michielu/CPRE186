package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.newdawn.slick.Image;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Play extends BasicGameState{
	
	/*
	 * int state is the ID number of the state 
	 * for play, it is 1
	 * Constructor 
	 */
	public Play(int state){ 
		
	}
	
	/*
	 * Built into Slick2D. Helps initialize crap it needs
	 */
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		
		
	}
	
	/*
	 * Draws stuff on a screen
	 * Graphics is like a paintbrush that paints everything we want it to
	 * Graphics are always named g
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//g.drawString("This is the play state", 100, 100);
	}
	
	/*
	 * Update: updates image on screen - 
	 * If we want animation, we need the screen to update
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
	}
	
	/*
	 * Returns the state of the game
	 * This returns 1 bc the Play's screen ID is 1
	 */
	public int getID(){
		return 1;
	}
}
