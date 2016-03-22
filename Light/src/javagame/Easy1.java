package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy1 extends BasicGameState{
	public static boolean shoot;
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
		Methods.currentStateNum = 11;
		gameBoard.draw(0,0);
		g.drawString(mouse, 50, 50);
		Methods.blankTiles();
		
		if(shoot){
			Methods.shoot();
		}

//		int xPos = Mouse.getX(); //gets the x position
//		int yPos = Mouse.getY(); //gets the y position
//		Input input = gc.getInput();
//		if((xPos<986 && xPos>820)&&(yPos>88&&yPos<130)){
//			if(input.isMouseButtonDown(0)){
//				Methods.shoot();
//			}
//		}

		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX(); //gets the x position
		int yPos = Mouse.getY(); //gets the y position
		mouse = "Mouse Position x: " + xPos + " y: " + yPos;
		Input input = gc.getInput();
		//Go to Menu state
		if((xPos>890 && xPos<1074) && (yPos<720 && yPos > 655)){
			if(input.isMouseButtonDown(0)){
				Play.canGoOn = false;
				sbg.enterState(0);
			}
		}
		if((xPos<986 && xPos>820)&&(yPos>88&&yPos<130)){
			if(input.isMouseButtonDown(0)){
				shoot = true;
			}
		}
		
		
		if(!input.isMouseButtonDown(0)){
			Play.canContinue=true;
		}
		
		if((xPos<311 && xPos>279)&&(yPos>16&&yPos<61)){
			if(Play.canContinue&&(input.isMouseButtonDown(0))){
				Play.canContinue = false;
				sbg.enterState(10);
			}
		}
		
		if((xPos<802 && xPos>770)&&(yPos>16&&yPos<61)){
			if(Play.canContinue&&(input.isMouseButtonDown(0))){
				Play.canContinue = false;
				sbg.enterState(12);
			}
		}
	}
	
	
	public int getID(){
		return 11;
	}
}
