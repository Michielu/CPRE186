package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.newdawn.slick.Image;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class EasyScreen extends BasicGameState{
	public String mouse = "No input yet";
	public EasyScreen(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(mouse, 50, 50);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
	}
	
	
	public int getID(){
		return 10;
	}
}
