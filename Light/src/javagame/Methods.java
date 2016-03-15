package javagame;

import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;


public class Methods extends BasicGameState {
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
		//TODO fix this bug
		//beamHorizontal = new Image("res/tile/beam_tile_horizontal(70x70).png");
		beamVertical = new Image("res/tile/beam_tile_vertical(70x70).png");
		beamCross = new Image("res/tile/cross.png");
		wallTile = new Image("res/tile/walltile(70x70).png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{

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
		if(currentStateNum == 21 ){
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
	}
	
	public int getID(){
		return 100;
	}
	
	public static void generateMedium1(){
		endTile.draw(400, 500);
		startTileUp.draw(260, 570);
		mDownRight.draw(260, 80);
		mDownLeft.draw(330, 80);
		mUpRight.draw(330, 570);
		mDownLeft.draw(750, 570);
		mDownRight.draw(750, 500);
	}
	public static void generateMedium2(){
		endTile.draw(470,80);
		startTileUp.draw(470, 570);
		mDownRight.draw(260,80);
		mDownLeft.draw(750, 80);
		mUpRight.draw(260,150);
		mUpLeft.draw(750, 150);
		mDownRight.draw(260, 500);
		mDownLeft.draw(750, 500);
		mUpRight.draw(260,570);
		mUpLeft.draw(750, 570);
		mDownRight.draw(540, 80);
		mUpRight.draw(540, 570);
		wallTile.draw(470,290);
	}
	public static void generateMedium3(){
		endTile.draw(680, 150);
		startTileUp.draw(750, 80);
		mDownRight.draw(260, 80);
		mUpRight.draw(260, 570);
		mUpLeft.draw(750, 570);
		mDownLeft.draw(750, 290);
		mDownRight.draw(470, 290);
		mUpRight.draw(470, 360);
		mDownLeft.draw(680, 360);
		mUpLeft.draw(680, 500);
		mUpRight.draw(330, 500);
		mDownRight.draw(330, 150);
		
	}
	public static void generateMedium4(){
		endTile.draw(750, 570);
		startTileUp.draw(260, 570);
		mDownRight.draw(260, 80);
		mDownLeft.draw(330, 80);
		mUpRight.draw(330, 570);
		mUpLeft.draw(400, 570);
		mDownRight.draw(400, 360);
		mDownRight.draw(X6, Y5);
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
}
