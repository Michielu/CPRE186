package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Medium5 extends BasicGameState{
	public static boolean shoot;
	public static boolean refresh;
	Image gameBoard;
	public String mouse = "No input yet";

	public Medium5(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		gameBoard = new Image("res/backgrounds/puzzle_baclground2(1080x720).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Methods.currentStateNum = 25;
		gameBoard.draw(0,0);
		g.drawString(mouse, 50, 50);
		Methods.blankTiles();
		
		if(shoot){
			Methods.shoot();
		}
		if(refresh){
			shoot = false;
			refresh = false;
			//Methods.blankTiles();
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
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
				sbg.enterState(24);
			}
		}
		
		if((xPos<802 && xPos>770)&&(yPos>16&&yPos<61)){
			if(Play.canContinue&&(input.isMouseButtonDown(0))){
				Play.canContinue = false;
				Play.canGoOn = false;
				sbg.enterState(30);
			}
		}
		
		if((xPos>524 && xPos<556) && (yPos<57 && yPos > 18)){
			if(input.isMouseButtonDown(0)){
				refresh = true;
				
			}
		}
	}
	
	
	public int getID(){
		return 25;
	}
}
