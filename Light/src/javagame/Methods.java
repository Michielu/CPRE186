package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;


public class Methods extends BasicGameState {
	public static int xStart = 260;
	public static int yStart = 80;
	public static int arrayX;
	public static int arrayY;
	public static int target = 100;
	//Mirrors
	public static int leftUp = 10;
	public static int leftDown = 20;
	public static int rightUp = 30;
	public static int rightDown = 40;
	
	public static int X1 = 260;
	public static int X2 = 330;
	public static int X3 = 400;
	public static int X4 = 470;
	public static int X5 = 540;
	public static int X6 = 610;
	public static int X7 = 680;
	public static int X8 = 750;
	public static int Y1 = 80;
	public static int Y2 = 150;
	public static int Y3 = 220;
	public static int Y4 = 290;
	public static int Y5 = 360;
	public static int Y6 = 430;
	public static int Y7 = 500;
	public static int Y8 = 570;
	
	public static int UP = 0;
	public static int RIGHT = 1;
	public static int DOWN = 2;
	public static int LEFT =3;
	public static int direction; 
	public static int[][] location = new int[9][9] ;
	
	
	
	
	
	public static int currentStateNum;
	//End Tiles
	public static Image endTile;
	public static Image endLightUp;
	public static Image endLightDown;
	public static Image endLightRight;
	public static Image endLightLeft;
	//Start Tiles
	public static Image startTileUp;
	public static Image startTileLeft;
	public static Image startTileRight;
	public static Image startTileDown;
	public static Image startLightUp;
	public static Image startLightDown;
	public static Image startLightLeft;
	public static Image startLightRight;
	//Mirrors
	public static Image mDownLeft;
	public static Image mDownLeftLight;
	public static Image mDownRight;
	public static Image mDownRightLight;
	public static Image mUpLeft;
	public static Image mUpLeftLight;
	public static Image mUpRight;
	public static Image mUpRightLight;
	//Tiles
	public static Image blankTile;
	public static Image beamHorizontal;
	public static Image beamVertical;
	public static Image beamCross;
	public static Image wallTile;
	
	public static Image menuButton;
	

	public Methods(int state){ 
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
		endTile = new Image("res/endTiles/end_tile_blank(70x70).png");
		endLightUp = new Image("res/endTiles/end_tile_up_(70x70).png");
		endLightDown = new Image("res/endTiles/end_tile_down(70x70).png");
		endLightRight = new Image("res/endTiles/end_tile_right(70x70).png");
		endLightLeft = new Image("res/endTiles/end_tile_left(70x70).png");
		startTileUp = new Image ("res/startTiles/start_up(70x70).png");
		startTileDown = new Image ("res/startTiles/start_down(70x70).png");
		startTileRight = new Image ("res/startTiles/start_right(70x70).png");
		startTileLeft = new Image ("res/startTiles/start_left_(70x70).png");
		startLightUp = new Image ("res/startTiles/start_tile_up_(70x70).png");
		startLightDown = new Image ("res/startTiles/start_tile_down(70x70).png");
		startLightLeft = new Image ("res/startTiles/start_tile_left(70x70).png");
		startLightRight = new Image ("res/startTiles/start_tile_right(70x70).png");
		mDownLeft = new Image ("res/mirrors/mirror_down_left(70x70).png");
		mDownLeftLight= new Image("res/mirrors/mirror_down_left_with_beam(70x70).png");
		mDownRight = new Image ("res/mirrors/mirror_down_right(70x70).png");
		mDownRightLight = new Image("res/mirrors/mirror_down_right_with_beam(70x70).png");
		mUpLeft = new Image ("res/mirrors/mirror_up_left(70x70).png");
		mUpLeftLight = new Image("res/mirrors/mirror_up_left_with_beam(70x70).png");
		mUpRight = new Image ("res/mirrors/mirror_up_right(70x70).png");
		mUpRightLight =new Image("res/mirrors/mirror_tile_up_right_with_beam(70x70).png");
		blankTile = new Image("res/tile/blank_tile(70x70).png");
		beamHorizontal = new Image("res/tile/beam_tile_horizontal(70x70).png");
		beamVertical = new Image("res/tile/beam_tile_vertical(70x70).png");
		beamCross = new Image("res/tile/cross.png");
		wallTile = new Image("res/tile/walltile(70x70).png");
		
		menuButton = new Image("res/buttons/menu_button(167x44).png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
	}
	
	public static void shoot() throws SlickException{
		/*xStart = x coordinate on GUI
		 * yStart = y coordinate on GUI
		 * arrayX = location[][] x position
		 * arrayY = location[][] y position	 
		 * 
		 */
		shootLight(direction, xStart, yStart, arrayX, arrayY);		
	}

	public static void blankTiles() throws SlickException{
		int xStart = 260;
		int yStart = 80;
		int i =0;
		int j = 0;
		for(i=0;i<8;i++){
			for(j=0; j<8;j++){
				blankTile.draw(xStart, yStart);
				yStart = yStart + 70;
			}
			xStart = xStart + 70;
			yStart = 80;
		}
		xStart = 260;
		yStart = 80;
		if (currentStateNum ==11){
			generateEasy1();
		}
		else if(currentStateNum == 12){
			generateEasy2();
		}
		else if (currentStateNum == 13){
			generateEasy3();
		}
		else if(currentStateNum == 14){
			generateEasy4();
		}
		else if(currentStateNum == 15){
			generateEasy5();
		}
		else if(currentStateNum == 21 ){
			generateMedium1();
		}
		else if(currentStateNum ==22){
			generateMedium2();
		}
		else if(currentStateNum ==23){
			generateMedium3();
		}
		else if(currentStateNum == 24){
			generateMedium4();
		}
		else if(currentStateNum ==25){
			generateMedium5();
		}
		else if(currentStateNum == 31){
			generateHard1();
		}
		else if(currentStateNum ==32){
			generateHard2();
		}
		else if(currentStateNum == 33){
			generateHard3();
		}
		else if(currentStateNum ==34){
			generateHard4();
		}
		else if (currentStateNum==35){
			generateHard5();
		}
	}

	
	public int getID(){
		return 100;
	}
	
	public static void generateEasy1(){
		menuButton.draw(820, 590);
		startTileRight.draw(X1,Y8);
		xStart =X1;
		yStart=Y8;
		arrayX = 1;
		arrayY =8;
		direction = 1;
		
		
		endTile.draw(X8, Y1);
		location[8][1] = target;
		
		
		mUpLeft.draw(X7, Y8);
		location[7][8]=leftUp;
		
		
		mDownRight.draw(X7,Y1);
		location[7][1] = rightDown;
		
		mDownRight.draw(X1,Y5);
		mUpLeft.draw(X8, Y5);
	}
	public static void generateEasy2(){
		startTileUp.draw(X3, Y8);
		direction = 0;
		endTile.draw(X6, Y2);
		mDownRight.draw(X3, Y1);
		mDownLeft.draw(X8, Y1);
		mUpLeft.draw(X8, Y7);
		mUpRight.draw(X2, Y7);
		mDownRight.draw(X2, Y2);
		
	}
	public static void generateEasy3(){
		startTileUp.draw(X3,Y8);
		direction = 0;
		endTile.draw(X5, Y1);
		mDownRight.draw(X3, Y6);
		mDownLeft.draw(X5, Y6);
		mUpRight.draw(X5, Y8);
		mUpLeft.draw(X8, Y8);
		mDownLeft.draw(X8, Y4);
		mUpRight.draw(X5, Y4);
	}
	public static void generateEasy4(){
		startTileRight.draw(X3, Y5);
		direction = 1;
		endTile.draw(X6, Y4);
		mDownLeft.draw(X7, Y5);
		mUpLeft.draw(X7, Y7);
		mDownRight.draw(X3, Y7);
		mUpRight.draw(X3, Y8);
		mUpLeft.draw(X8, Y8);
		mDownLeft.draw(X8, Y1);
		mDownRight.draw(X6, Y1);
	}
	public static void generateEasy5(){
		startTileRight.draw(X1, Y8);
		direction = 1;
		endTile.draw(X4, Y4);
		mUpLeft.draw(X8, Y8);
		mDownLeft.draw(X8, Y1);
		mDownRight.draw(X1, Y1);
		mUpRight.draw(X1, Y7);
		mUpLeft.draw(X7, Y7);
		mDownLeft.draw(X7, Y2);
		mDownRight.draw(X2, Y2);
		mUpRight.draw(X2, Y6);
		mUpLeft.draw(X6, Y6);
		mDownLeft.draw(X6, Y3);
		mDownRight.draw(X3, Y3);
		mUpRight.draw(X3, Y5);
		mUpLeft.draw(X5,Y5);
		mDownLeft.draw(X5, Y4);
	}	
	public static void generateMedium1(){
		endTile.draw(X3, Y7);
		startTileUp.draw(X1, Y8);
		mDownRight.draw(X1, Y1);
		mDownLeft.draw(X2, Y1);
		mUpRight.draw(X2, 570);
		mDownLeft.draw(X8, Y7);
		mUpLeft.draw(X8, Y8);
	}
	public static void generateMedium2(){
		endTile.draw(X4,Y1);
		startTileUp.draw(X4, Y8);
		mDownRight.draw(X1,Y1);
		mDownLeft.draw(X8, Y1);
		mUpRight.draw(X1,Y2);
		mUpLeft.draw(X8, Y2);
		mDownRight.draw(X1, Y7);
		mDownLeft.draw(X8, Y7);
		mUpRight.draw(X1,Y8);
		mUpLeft.draw(X8, Y8);
		mDownRight.draw(X5, Y1);
		mUpRight.draw(X5, Y8);
		wallTile.draw(X4,Y4);
	}
	public static void generateMedium3(){
		endTile.draw(X7, Y2);
		startTileUp.draw(X8, Y1);
		mDownRight.draw(X1, Y1);
		mUpRight.draw(X1, Y8);
		mUpLeft.draw(X8, Y8);
		mDownLeft.draw(X8, Y4);
		mDownRight.draw(X4, Y4);
		mUpRight.draw(X4, Y5);
		mDownLeft.draw(X7, Y5);
		mUpLeft.draw(X7, Y7);
		mUpRight.draw(X2, Y7);
		mDownRight.draw(X2, Y2);
		
	}
	public static void generateMedium4(){
		endTile.draw(X8, Y8);
		startTileUp.draw(X1, Y8);
		mDownRight.draw(X1, Y1);
		mDownLeft.draw(X2, Y1);
		mUpRight.draw(X2, Y8);
		mUpLeft.draw(X3, Y8);
		mDownRight.draw(X3, Y5);
		mDownLeft.draw(X6, Y5);
		mUpRight.draw(X6, Y8);
		mUpLeft.draw(X7, Y8);
		mDownRight.draw(X7, Y1);
		mDownLeft.draw(X8, Y1);
		
	}
	public static void generateMedium5(){

		endTile.draw(X2, Y2);
		startTileUp.draw(X1, Y1);
		mDownRight.draw(X8, Y1);
		mUpLeft.draw(X8, Y2);
		mDownRight.draw(X5, Y2);
		mUpLeft.draw(X5, Y8);
		mUpRight.draw(X4, Y8);
		mDownLeft.draw(X4, Y2);
	}
	public static void generateHard1(){
		startTileUp.draw(X3, Y8);
		endTile.draw(X7, Y1);
		mUpRight.draw(X2, Y8);
		mDownRight.draw(X2, Y6);
		mDownLeft.draw(X7, Y6);
		mUpLeft.draw(X7, Y7);
		mUpRight.draw(X1, Y7);
		mDownRight.draw(X1, Y5);
		mUpLeft.draw(X3, Y5);
		mDownRight.draw(X3, Y3);
		mDownLeft.draw(X4, Y3);
		mUpLeft.draw(X4, Y4);
		mUpRight.draw(X1, Y4);
		mDownRight.draw(X1, Y1);
		wallTile.draw(X7, Y4);
		//Distraction tiles TODO add more
		mUpRight.draw(X8, Y3);
		mDownLeft.draw(X8, Y5);
	}
	public static void generateHard2(){
		startTileUp.draw(X6, Y3);
		endTile.draw(X1, Y7);
		mUpRight.draw(X6, Y5);
		mUpLeft.draw(X8, Y5);
		mDownLeft.draw(X8, Y1);
		mDownRight.draw(X5, Y1);
		mUpLeft.draw(X5,  Y3);
		mUpRight.draw(X2, Y3);
		mDownRight.draw(X2, Y1);
		mDownLeft.draw(X3, Y1);
		mUpLeft.draw(X3, Y2);
		mDownRight.draw(X1, Y2);
		mUpRight.draw(X1, Y6);
		mDownLeft.draw(X6, Y6);
		mUpLeft.draw(X6, Y8);
		mUpRight.draw(X4, Y8);
		mDownLeft.draw(X4, Y4);
		mDownRight.draw(X3, Y4);
		mUpLeft.draw(X3, Y7);
		//TODO add distracting mirrors
	}
	public static void generateHard3(){
		startTileDown.draw(X1, Y1);
		endTile.draw(X8, Y1);
		mUpRight.draw(X1, Y8);
		mUpLeft.draw(X2, Y8);
		mDownRight.draw(X2, Y5);
		mUpLeft.draw(X3, Y5);
		mDownRight.draw(X3, Y1);
		mDownLeft.draw(X4, Y1);
		mUpRight.draw(X4, Y8);
		mUpLeft.draw(X8, Y8);
		mDownLeft.draw(X8,Y7);
		mUpRight.draw(X6, Y7);
		mDownLeft.draw(X6, Y2);
		mUpRight.draw(X5, Y2);
		mDownRight.draw(X5, Y1);
		wallTile.draw(X8,Y2);
		//TODO add distracting mirrors
		mUpRight.draw(X3, Y6);
		mUpLeft.draw(X8, Y6);
		
	}
	public static void generateHard4(){
		startTileUp.draw(X4, Y4);
		endTile.draw(X5, Y5);
		mUpRight.draw(X4, Y6);
		mUpLeft.draw(X6, Y6);
		mDownRight.draw(X6, Y4);
		mDownLeft.draw(X7, Y4);
		mUpLeft.draw(X7, Y7);
		mUpRight.draw(X3, Y7);
		mDownRight.draw(X3, Y3);
		mUpLeft.draw(X8, Y3);
		mDownLeft.draw(X8,Y2);
		mDownRight.draw(X2, Y2);
		mUpLeft.draw(X2, Y8);
		mUpRight.draw(X1, Y8);
		mDownRight.draw(X1, Y5);
		//TODO add distracting mirrors and walls
	}
	public static void generateHard5(){
		startTileUp.draw(X2, Y5);
		endTile.draw(X7, Y3);
		mDownRight.draw(X2, Y4);
		mDownLeft.draw(X4, Y4);
		mUpRight.draw(X4,Y6);
		mUpLeft.draw(X8, Y6);
		mDownLeft.draw(X8, Y2);
		mDownRight.draw(X5, Y2);
		mUpLeft.draw(X5, Y7);
		mUpRight.draw(X1, Y7);
		mDownRight.draw(X1, Y1);
		mDownLeft.draw(X6, Y1);
		mUpLeft.draw(X6, Y8);
		mUpRight.draw(X3, Y8);
		mDownRight.draw(X3,Y3);
		//TODO add distracting mirrors and walls
	}
	public static void shootLight(int direction, int startX, int startY, int aX, int aY){
		//beamVertical.draw(startX,startY);
		if(direction == 0){
			
		}
		else if(direction ==1){
			startLightRight.draw(startX,startY);
			startX+=70;
			while(aX<8){
				beamHorizontal.draw(startX, startY);
				startX+=70;
				aX+=1;
				if(location[aX][aY]==leftUp){
					startX -= 70;
					direction = UP;
					break;
				}
			}
			if(location[aX][aY] == leftUp){
				mUpLeftLight.draw(startX,startY);
				startY-=70;
				while(aY>0 && aY <= 8){
					beamVertical.draw(startX, startY);
					startY-=70;
					aY-=1;
					if(location[aX][aY] == rightDown){
						break;
					}
				}
			}
		}
		else if(direction ==2){
			
		}
		else if(direction ==3){
			
		}
	}
}
