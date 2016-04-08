package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

//Every screen inherits from BasicGameState. Extends = inherits
public class Easy1 extends BasicGameState{
	public static boolean shoot;
	public static boolean refresh;

	public static boolean blankTileOnce = true;
	Image gameBoard;
	public static Image tileNormal;
	public String mouse = "No input yet";

	
	//Created for rotating mirrors thingie
	public static boolean rotate;
	public int numRotates =0;
	public static boolean isButtonUp;

	
	
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

			
			
		if(numRotates == 0){
			Methods.generateBoard();
		}
		else if(numRotates != 0){
			Methods.generateBoardRotated();
		}
		
		
		
		if(shoot){
			Methods.shoot();
			
		}
		if(refresh){
			shoot = false;
			refresh = false;
			//Added this with rotates stuff
			numRotates = 0;
		}
		if(rotate){
			
			//Methods.finished = false;
			numRotates++;
			Methods.changeLocation= true;
			rotate = false;
			Methods.rotateMirrorOnce = true;

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
		//Added ALL OF THIS  for game
		if((xPos>682 && xPos<746)&&(yPos>83 && yPos<145)){
			if(input.isMouseButtonDown(0)){
				//ADDED THIS FOR ROTATES
				isButtonUp = true;		
			}
		}
		if(isButtonUp){
			if(!input.isMouseButtonDown(0)){
				rotate = true;
				isButtonUp = false;
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
		if((xPos>524 && xPos<556) && (yPos<57 && yPos > 18)){
			if(input.isMouseButtonDown(0)){
				refresh = true;
				
			}
		}

	}
	
	
	public int getID(){
		return 11;
	}
}
