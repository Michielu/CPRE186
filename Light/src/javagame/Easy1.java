package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy1 extends BasicGameState{
	Image gameBoard;
	public static Image tileNormal;
	public String mouse = "No input yet";

	public Easy1(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		gameBoard = new Image("res/backgrounds/puzzle_background1(1080x720).png");
		tileNormal = new Image("res/tile/blank_tile(70x70).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		gameBoard.draw(0,0);
		g.drawString(mouse, 50, 50);
		Methods.blankTiles();
		//Image hello = Images.getTile();
		

		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX(); //gets the x position
		int yPos = Mouse.getY(); //gets the y position
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
		Input input = gc.getInput();
		//Go to Menu state
		if((xPos>890 && xPos<1074) && (yPos<720 && yPos > 655)){
			if(input.isMouseButtonDown(0)){
				sbg.enterState(0);
			}
		}
	}
	
	
	public int getID(){
		return 11;
	}
}
