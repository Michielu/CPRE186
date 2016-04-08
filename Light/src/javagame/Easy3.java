package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy3 extends BasicGameState{
	public static boolean shoot;
	public static boolean refresh;
	Image background ;
	public Easy3(int state){ 
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		background = new Image("res/backgrounds/puzzle_background1(1080x720).png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Methods.currentStateNum = 13;
		background.draw(0, 0);
		Methods.blankTiles();
		Methods.generateBoard();
		
		if(shoot){
			Methods.shoot();
		}
		if(refresh){
			shoot = false;
			refresh = false;
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
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
				sbg.enterState(12);
			}
		}
		
		if((xPos<802 && xPos>770)&&(yPos>16&&yPos<61)){
			if(Play.canContinue&&(input.isMouseButtonDown(0))){
				Play.canContinue = false;
				sbg.enterState(14);
			}
		}
		if((xPos>524 && xPos<556) && (yPos<57 && yPos > 18)){
			if(input.isMouseButtonDown(0)){
				refresh = true;
				
			}
		}
	}
	
	
	public int getID(){
		return 13;
	}
}
