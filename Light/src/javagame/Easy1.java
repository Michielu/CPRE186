package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.newdawn.slick.Image;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy1 extends BasicGameState{
	Image gameBoard;
	public Easy1(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		gameBoard = new Image("res/puzzle_buttons_dimensions.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
	}
	
	
	public int getID(){
		return 11;
	}
}
