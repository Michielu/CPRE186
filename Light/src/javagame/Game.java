package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
		//Game name
		public static final String gamename = "Light"; //hello
		//Giving the state "menu" the number 0 to help differentiate 
		public static final int menu = 0;
		//Giving the state "play"(when they're playing the game) the number 1
		public static final int play =1;
		public static final int credit = 2;
		public static final int easyScreen = 10;
		public static final int easy1 = 11;
		public static final int easy2 = 12;
		public static final int easy3 = 13;
		public static final int easy4 = 14;
		public static final int easy5 = 15;
		public static final int mediumScreen = 20;
		public static final int medium1 = 21;
		public static final int medium2 = 22;
		public static final int medium3 = 23;
		public static final int medium4 = 24;
		public static final int medium5 = 25;
		public static final int hardScreen = 30;
		public static final int hard1 = 31;
		public static final int hard2 = 32;
		public static final int hard3 = 33;
		public static final int hard4 = 34;
		public static final int hard5 = 35;
		//TODO I'll wait until I get the general picture before I add other 10 states
		
		
		//Create a constructor - first method that gets called whenever an 
		// object of it's class get's created
		//Game is the same name as it's class.
		//Passing in the game name as a parameter 
		public Game(String gamename){ 
			super(gamename); //Gives title at the top of the game/window
			this.addState(new Menu(menu)); //Add each state
			this.addState(new Play(play));
			this.addState(new Credit(credit));
			this.addState(new EasyScreen(easyScreen));
			this.addState(new Easy1(easy1));
			this.addState(new Easy2(easy2));
			this.addState(new Easy3(easy3));
			this.addState(new Easy4(easy4));
			this.addState(new Easy5(easy5));
			this.addState(new MediumScreen(mediumScreen));
			this.addState(new Medium1(medium1));
			this.addState(new Medium2(medium2));
			this.addState(new Medium3(medium3));
			this.addState(new Medium4(medium4));
			this.addState(new Medium5(medium5));
			this.addState(new HardScreen(hardScreen));
			this.addState(new Hard1(hard1));
			this.addState(new Hard2(hard2));
			this.addState(new Hard3(hard3));
			this.addState(new Hard4(hard4));
			this.addState(new Hard5(hard5));
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
			this.getState(credit).init(gc, this);
			this.getState(easyScreen).init(gc, this);
			this.getState(easy1).init(gc, this);
			this.getState(easy2).init(gc, this);
			this.getState(easy3).init(gc,  this);
			this.getState(easy4).init(gc, this);
			this.getState(easy5).init(gc,  this);
			this.getState(mediumScreen).init(gc, this);
			this.getState(medium1).init(gc, this);
			this.getState(medium2).init(gc, this);
			this.getState(medium3).init(gc,  this);
			this.getState(medium4).init(gc, this);
			this.getState(medium5).init(gc,  this);
			this.getState(hardScreen).init(gc, this);
			this.getState(hard1).init(gc, this);
			this.getState(hard2).init(gc, this);
			this.getState(hard3).init(gc,  this);
			this.getState(hard4).init(gc, this);
			this.getState(hard5).init(gc,  this);
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
