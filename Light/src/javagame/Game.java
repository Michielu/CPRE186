package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
		//Game name
		public static final String gamename = "Light";
		//Giving the state "menu" the number 0 to help differentiate 
		public static final int menu = 0;
		//Giving the state "play"(when they're playing the game) the number 1
		//TODO Create states needed for the game
		public static final int play =1;
		
		//Create a constructor - first method that gets called whenever an 
		// object of it's class get's created
		//Game is the same name as it's class.
		//Passing in the game name as a parameter 
		public Game(String gamename){ 
			super(gamename); //Gives title at the top of the game/window
			this.addState(new Menu(menu)); //Add each state
			this.addState(new Play(play));
		}
		 /*The method required in inheriting StateBasedGame
		  *GameContainer is the thing that's responsible for the main game loop
		  * the frame rate, input system, behind the scene stuff
		  * -- Pretty much exalains what sort of game this is
		  * have to initialize the list of states that make up this game
		  * 
		  * gc = game container 
		  * init = initialize 
		  * 
		  * this.getState.... - initializes the state
		  * enterState = what screen to first show the user.
		  */
		public void initStatesList(GameContainer gc) throws SlickException{ 
			this.getState(menu).init(gc, this);
			this.getState(play).init(gc, this);
			this.enterState(menu); 
		}
		
		
		public static void main(String[] args) {
			/*AppGameContainer: Slick's for whenever I make a window
			 * Whenever I make a window, make it in the main.
			 */
			AppGameContainer appgc; //App game container - object. appgc is the window itself
			try{
				/*
				 * It's a window that's containing a computer game "new game(gamename)"
				 */
				appgc = new AppGameContainer(new Game(gamename)); //What's in the window
				//Set size of the window - adjusting
				appgc.setDisplayMode(1080, 720, false); //How big the window's going to be. (width, length, fullscreen)
				appgc.start();
				
			}catch(SlickException e){ //Slick's built in Error statement
				e.printStackTrace();
			}
			
		
		}
}