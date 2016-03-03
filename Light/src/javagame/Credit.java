package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Credit extends BasicGameState{
	Image tempImage;
	public String mouse = "No input yet";
	public Credit(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		tempImage = new Image("res/backgrounds/creditexit.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		tempImage.draw(0, 0);
		g.drawString(mouse, 50, 50);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
		Input input = gc.getInput();
		
		//As soon as the mouse is pressed, it closes because the same spot has exit on the credits page
		if((xPos >444&& xPos<650)&& (yPos>214 && yPos < 425)){
			  if(input.isMouseButtonDown(0)){
				  System.exit(0);
			  }
		  }
		
		//This is also temporary; as soon as you click slightly above the exit button in credits, it take you to menu
		if((xPos >444&& xPos<650) && (yPos<620 && yPos > 440)){
			//This checks to see if the mouse button is down
			if(input.isMouseButtonDown(0)){
				sbg.enterState(0);
			}
		}
	}
	
	
	public int getID(){
		return 2;
	}
}
