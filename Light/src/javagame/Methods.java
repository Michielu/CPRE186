package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;

public class Methods extends BasicGameState {
	static ArrayList<Cell> list = new ArrayList<>();
	public static boolean startLight;
	// For rotate method
	static boolean finished = false;
	static boolean changeLocation;
	public static boolean rotateMirrorOnce = false; // For rotateMirror method
	public static int xRotate = 1;
	public static int yRotate = 8;

	public static int xStart = 260;
	public static int yStart = 80;
	public static int arrayX;
	public static int arrayY;
	public static int target = 100;
	// Mirrors
	public static int leftUp = 10;
	public static int leftDown = 40;
	public static int rightUp = 20;
	public static int rightDown = 30;
	public static int wall = 50;
	public static int vertLight = 51;
	public static int horizLight = 52;
	public static int cross = 1000;

	public static int startUp = 6;
	public static int startRight = 7;
	public static int startDown = 8;
	public static int startLeft = 9;

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
	public static int LEFT = 3;
	public static int direction;
	public static int[][] location = new int[10][10];
	public static boolean[][] locationBool = new boolean[10][10];

	public static int currentStateNum;
	// End Tiles
	public static Image endTile;
	public static Image endLightUp;
	public static Image endLightDown;
	public static Image endLightRight;
	public static Image endLightLeft;
	// Start Tiles
	public static Image startTileUp;
	public static Image startTileLeft;
	public static Image startTileRight;
	public static Image startTileDown;
	public static Image startLightUp;
	public static Image startLightDown;
	public static Image startLightLeft;
	public static Image startLightRight;
	// Mirrors
	public static Image mDownLeft;
	public static Image mDownLeftLight;
	public static Image mDownRight;
	public static Image mDownRightLight;
	public static Image mUpLeft;
	public static Image mUpLeftLight;
	public static Image mUpRight;
	public static Image mUpRightLight;
	// Tiles
	public static Image blankTile;
	public static Image beamHorizontal;
	public static Image beamVertical;
	public static Image beamCross;
	public static Image wallTile;

	public static Image menuButton;

	public static Image powerOn;
	public static Image powerOff;
	public static Image levelComplete;

	public Methods(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		endTile = new Image("res/endTiles/end_tile_blank(70x70).png");
		endLightUp = new Image("res/endTiles/end_tile_up_(70x70).png");
		endLightDown = new Image("res/endTiles/end_tile_down(70x70).png");
		endLightRight = new Image("res/endTiles/end_tile_right(70x70).png");
		endLightLeft = new Image("res/endTiles/end_tile_left(70x70).png");
		startTileUp = new Image("res/startTiles/start_up(70x70).png");
		startTileDown = new Image("res/startTiles/start_down(70x70).png");
		startTileRight = new Image("res/startTiles/start_right(70x70).png");
		startTileLeft = new Image("res/startTiles/start_left_(70x70).png");
		startLightUp = new Image("res/startTiles/start_tile_up_(70x70).png");
		startLightDown = new Image("res/startTiles/start_tile_down(70x70).png");
		startLightLeft = new Image("res/startTiles/start_tile_left(70x70).png");
		startLightRight = new Image("res/startTiles/start_tile_right(70x70).png");
		mDownLeft = new Image("res/mirrors/mirror_down_left(70x70).png");
		mDownLeftLight = new Image("res/mirrors/mirror_down_left_with_beam(70x70).png");
		mDownRight = new Image("res/mirrors/mirror_down_right(70x70).png");
		mDownRightLight = new Image("res/mirrors/mirror_down_right_with_beam(70x70).png");
		mUpLeft = new Image("res/mirrors/mirror_up_left(70x70).png");
		mUpLeftLight = new Image("res/mirrors/mirror_up_left_with_beam(70x70).png");
		mUpRight = new Image("res/mirrors/mirror_up_right(70x70).png");
		mUpRightLight = new Image("res/mirrors/mirror_tile_up_right_with_beam(70x70).png");
		blankTile = new Image("res/tile/blank_tile(70x70).png");
		beamHorizontal = new Image("res/tile/beam_tile_horizontal(70x70).png");
		beamVertical = new Image("res/tile/beam_tile_vertical(70x70).png");
		beamCross = new Image("res/tile/cross.png");
		wallTile = new Image("res/tile/walltile(70x70).png");

		menuButton = new Image("res/buttons/menu_button(167x44).png");
		powerOn = new Image("res/buttons/power_on(167x44).png");
		powerOff = new Image("res/buttons/power_off(167x44).png");
		levelComplete = new Image("res/buttons/level_complete(1080x720).png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

	}

	public static void shoot() throws SlickException {
		powerOn.draw(820, 590);
		if (direction == 0) {
			shootUp(direction, xStart, yStart, arrayX, arrayY);
		}
		if (direction == 1) {
			shootRight(direction, xStart, yStart, arrayX, arrayY);
		}
		if (direction == 2) {
			shootDown(direction, xStart, yStart, arrayX, arrayY);

		}
		if (direction == 3) {
			shootLeft(direction, xStart, yStart, arrayX, arrayY);
		}
	}

	public static void blankTiles() throws SlickException {
		int xStart = 260;
		int yStart = 80;
		int i = 0;
		int j = 0;
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				blankTile.draw(xStart, yStart);
				yStart = yStart + 70;
				// locationBool[i+1][j+1] = true;
			}
			xStart = xStart + 70;
			yStart = 80;
		}
		xStart = 260;
		yStart = 80;
	}

	public static void generateBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				locationBool[i + 1][j + 1] = true;
			}
		}
		if (currentStateNum == 11) {
			generateEasy1();
		} else if (currentStateNum == 12) {
			generateEasy2();
		} else if (currentStateNum == 13) {
			generateEasy3();
		} else if (currentStateNum == 14) {
			generateEasy4();
		} else if (currentStateNum == 15) {
			generateEasy5();
		} else if (currentStateNum == 21) {
			generateMedium1();
		} else if (currentStateNum == 22) {
			generateMedium2();
		} else if (currentStateNum == 23) {
			generateMedium3();
		} else if (currentStateNum == 24) {
			generateMedium4();
		} else if (currentStateNum == 25) {
			generateMedium5();
		} else if (currentStateNum == 31) {
			generateHard1();
		} else if (currentStateNum == 32) {
			generateHard2();
		} else if (currentStateNum == 33) {
			generateHard3();
		} else if (currentStateNum == 34) {
			generateHard4();
		} else if (currentStateNum == 35) {
			generateHard5();
		}
	}

	public int getID() {
		return 100;
	}

	public static void generateBoardRotated() {

		if (currentStateNum == 11) {
			generateEasy1Rotated();
		} else if (currentStateNum == 12) {
			generateEasy2Rotated();
		} else if (currentStateNum == 13) {
			generateEasy3Rotated();
		} else if (currentStateNum == 14) {
			generateEasy4Rotated();
		} else if (currentStateNum == 15) {
			generateEasy5Rotated();
		} else if (currentStateNum == 21) {
			generateMedium1Rotated();
		} else if (currentStateNum == 22) {
			generateMedium2Rotated();
		} else if (currentStateNum == 23) {
			generateMedium3Rotated();
		} else if (currentStateNum == 24) {
			generateMedium4Rotated();
		} else if (currentStateNum == 25) {
			generateMedium5Rotated();
		} else if (currentStateNum == 31) {
			generateHard1Rotated();
		} else if (currentStateNum == 32) {
			generateHard2Rotated();
		} else if (currentStateNum == 33) {
			generateHard3Rotated();
		} else if (currentStateNum == 34) {
			generateHard4Rotated();
		} else if (currentStateNum == 35) {
			generateHard5Rotated();
		}
	}

	public static void generateEasy1() {
		clearArray();
		powerOff.draw(820, 590);
		startTileRight.draw(X1, Y8);
		location[1][8] = startRight;
		startLight = true;

		xStart = X1;
		yStart = Y8;
		arrayX = 1;
		arrayY = 8;
		direction = 1;

		endTile.draw(X8, Y1);
		location[8][1] = target;

		// mUpLeft.draw(X7, Y8);
		// location[7][8]=leftUp;
		mUpRight.draw(X7, Y8);
		location[7][8] = rightUp;

		mDownRight.draw(X7, Y1);
		location[7][1] = rightDown;

		// mDownRight.draw(X1,Y5);
		// location[1][5] = rightDown;
		mDownLeft.draw(X1, Y5);
		location[1][5] = leftDown;

		mUpLeft.draw(X8, Y5);
		location[8][5] = leftUp;
	}

	public static void generateEasy1Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X8, Y1);
		location[8][1] = target;

		if (locationBool[1][8]) {
			startTileRight.draw(X1, Y8);
			// location[1][8] = startRight;

		}

		if (locationBool[7][8]) {
			// mUpLeft.draw(X7, Y8);
			mUpRight.draw(X7, Y8);
		}

		if (locationBool[7][1]) {
			mDownRight.draw(X7, Y1);
		}

		if (locationBool[1][5]) {
			// mDownRight.draw(X1,Y5);
			mDownLeft.draw(X1, Y5);
		}

		if (locationBool[8][5]) {
			mUpLeft.draw(X8, Y5);
			// location[8][5] = leftUp;
		}

		generateRotatedAid();
	}

	public static void generateEasy2Rotated() {

		startLight = true;
		powerOff.draw(820, 590);
		endTile.draw(X6, Y2);
		location[6][2] = target;

		if (locationBool[3][8]) {
			startTileUp.draw(X3, Y8);
		}

		if (locationBool[3][1]) {
			mDownRight.draw(X3, Y1);
		}

		if (locationBool[8][1]) {
			// mDownLeft.draw(X8, Y1);
			// location[8][1] = leftDown;
			mDownRight.draw(X8, Y1);
		}

		if (locationBool[8][7]) {
			mUpLeft.draw(X8, Y7);
		}

		if (locationBool[2][7]) {
			// mUpRight.draw(X2, Y7);
			// location[2][7] = rightUp;
			mDownRight.draw(X2, Y7);
		}

		if (locationBool[2][2]) {
			mDownRight.draw(X2, Y2);
		}

		generateRotatedAid();
	}

	public static void generateEasy3Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X5, Y1);
		location[5][1] = target;

		if (locationBool[3][8]) {
			startTileUp.draw(X3, Y8);
		}

		if (locationBool[3][6]) {
			mDownRight.draw(X3, Y6);
		}

		if (locationBool[5][6]) {
			// mDownLeft.draw(X5, Y6);
			// location[5][6] = leftDown;
			mDownRight.draw(X5, Y6);
		}
		if (locationBool[5][8]) {
			mUpRight.draw(X5, Y8);
		}

		if (locationBool[8][8]) {
			// mUpLeft.draw(X8, Y8);
			// location[8][8] = leftUp;
			mDownRight.draw(X8, Y8);
		}
		if (locationBool[8][4]) {
			mDownLeft.draw(X8, Y4);
		}
		if (locationBool[5][4]) {
			mUpRight.draw(X5, Y4);
		}

		generateRotatedAid();
	}

	public static void generateEasy4Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X6, Y4);
		location[6][4] = target;

		if (locationBool[3][5]) {
			startTileRight.draw(X3, Y5);
		}

		if (locationBool[7][5]) {
			mDownLeft.draw(X7, Y5);
		}

		if (locationBool[7][7]) {
			// mUpLeft.draw(X7, Y7);
			// location[7][7]=leftUp;
			mDownRight.draw(X7, Y7);
		}

		if (locationBool[3][7]) {
			mDownRight.draw(X3, Y7);
		}

		if (locationBool[3][8]) {
			mUpRight.draw(X3, Y8);
		}

		if (locationBool[8][8]) {
			// mUpLeft.draw(X8, Y8);
			// location[8][8] = leftUp;
			mUpRight.draw(X8, Y8);
		}

		if (locationBool[8][1]) {
			mDownLeft.draw(X8, Y1);
		}
		if (locationBool[6][1]) {
			mDownRight.draw(X6, Y1);
		}

		generateRotatedAid();
	}

	public static void generateEasy5Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X4, Y4);
		location[4][4] = target;

		if (locationBool[1][8]) {
			startTileRight.draw(X1, Y8);
		}
		if (locationBool[8][8]) {
			mUpLeft.draw(X8, Y8);
		}
		if (locationBool[8][1]) {
			// mDownLeft.draw(X8, Y1);
			// location[8][1] = leftDown;
			mDownRight.draw(X8, Y1);
		}

		if (locationBool[1][1]) {
			mDownRight.draw(X1, Y1);
		}

		if (locationBool[1][7]) {
			mUpRight.draw(X1, Y7);
		}
		if (locationBool[7][7]) {
			mUpLeft.draw(X7, Y7);
		}
		if (locationBool[7][2]) {
			// mDownLeft.draw(X7, Y2);
			// location[7][2] =leftDown;
			mUpLeft.draw(X7, Y2);
		}
		if (locationBool[2][2]) {
			mDownRight.draw(X2, Y2);
		}
		if (locationBool[2][6]) {
			mUpRight.draw(X2, Y6);
		}
		if (locationBool[6][6]) {
			mUpLeft.draw(X6, Y6);
		}
		if (locationBool[6][3]) {
			mDownLeft.draw(X6, Y3);
		}
		if (locationBool[3][3]) {
			mDownRight.draw(X3, Y3);
		}
		if (locationBool[3][5]) {
			mUpRight.draw(X3, Y5);
		}
		if (locationBool[5][5]) {
			mUpLeft.draw(X5, Y5);
		}
		if (locationBool[5][4]) {
			mDownLeft.draw(X5, Y4);
		}

		generateRotatedAid();
	}

	public static void generateMedium1Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X3, Y7);
		location[3][7] = target;

		if (locationBool[1][8]) {
			startTileUp.draw(X1, Y8);
		}

		if (locationBool[1][1]) {
			mDownRight.draw(X1, Y1);
		}
		if (locationBool[2][1]) {
			// mDownLeft.draw(X2, Y1);
			mUpLeft.draw(X2, Y1);
		}
		if (locationBool[2][8]) {
			// mUpRight.draw(X2, Y8);
			mUpLeft.draw(X2, Y8);
		}
		if (locationBool[8][8]) {
			mUpLeft.draw(X8, Y8);
		}
		if (locationBool[8][7]) {
			// mDownLeft.draw(X8, Y7);
			mDownRight.draw(X8, Y7);
		}

		generateRotatedAid();
	}

	public static void generateMedium2Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X4, Y1);
		location[4][1] = target;

		if (locationBool[4][8]) {
			startTileLeft.draw(X4, Y8);
		}

		if (locationBool[1][8]) {
			mUpRight.draw(X1, Y8);
		}
		if (locationBool[1][7]) {
			// mDownRight.draw(X1, Y7);
			mDownLeft.draw(X1, Y7);
		}
		if (locationBool[8][7]) {
			mDownLeft.draw(X8, Y7);
		}
		if (locationBool[8][8]) {
			// mUpLeft.draw(X8, Y8);
			mDownRight.draw(X8, Y8);
		}
		if (locationBool[5][8]) {
			mUpRight.draw(X5, Y8);
		}
		if (locationBool[5][1]) {
			// mDownRight.draw(X5, Y1);
			mDownLeft.draw(X5, Y1);
		}
		if (locationBool[8][1]) {
			mDownLeft.draw(X8, Y1);
		}
		if (locationBool[8][2]) {
			mUpLeft.draw(X8, Y2);
		}
		if (locationBool[1][2]) {
			mUpRight.draw(X1, Y2);
		}
		if (locationBool[1][1]) {
			mDownRight.draw(X1, Y1);
		}
		if (locationBool[4][4]) {
			wallTile.draw(X4, Y4);
		}

		generateRotatedAid();
	}

	public static void generateMedium3Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X7, Y2);
		location[7][2] = target;

		if (locationBool[8][1]) {
			startTileLeft.draw(X8, Y1);
		}
		if (locationBool[1][2]) {
			mDownRight.draw(X1, Y1);
		}
		if (locationBool[1][8]) {
			// mUpRight.draw(X1, Y8);
			mDownRight.draw(X1, Y8);
		}
		if (locationBool[8][8]) {
			// mUpLeft.draw(X8, Y8);
			mUpRight.draw(X8, Y8);
		}
		if (locationBool[8][4]) {
			mDownLeft.draw(X8, Y4);
		}
		if (locationBool[4][4]) {
			mDownRight.draw(X4, Y4);
		}
		if (locationBool[4][5]) {
			mUpRight.draw(X4, Y5);
		}
		if (locationBool[7][5]) {
			// mDownLeft.draw(X7, Y5);
			mUpRight.draw(X7, Y5);
		}
		if (locationBool[7][7]) {
			mUpLeft.draw(X7, Y7);
		}
		if (locationBool[2][7]) {
			mUpRight.draw(X2, Y7);
		}
		if (locationBool[2][2]) {
			mDownRight.draw(X2, Y2);
		}

		generateRotatedAid();
	}

	public static void generateMedium4Rotated() {
		startLight = true;
		powerOff.draw(820, 590);
		endTile.draw(X8, Y8);
		location[8][8] = target;

		if (locationBool[1][8]) {
			startTileUp.draw(X1, Y8);
		}
		if (locationBool[1][1]) {
			// mDownRight.draw(X1, Y1);
			mUpLeft.draw(X1, Y1);
		}
		if (locationBool[2][1]) {
			mDownLeft.draw(X2, Y1);
		}
		if (locationBool[2][8]) {
			// mUpRight.draw(X2, Y8);
			mDownRight.draw(X2, Y8);
		}
		if (locationBool[3][8]) {
			mUpLeft.draw(X3, Y8);
		}
		if (locationBool[3][5]) {
			mDownRight.draw(X3, Y5);
		}

		if (locationBool[6][5]) {
			mDownLeft.draw(X6, Y5);
		}
		if (locationBool[6][8]) {
			// mUpRight.draw(X6, Y8);
			mUpLeft.draw(X6, Y8);
		}
		if (locationBool[7][8]) {
			mUpLeft.draw(X7, Y8);
		}
		if (locationBool[7][1]) {
			mDownRight.draw(X7, Y1);
		}
		if (locationBool[8][1]) {
			mDownLeft.draw(X8, Y1);
		}

		generateRotatedAid();
	}

	public static void generateMedium5Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X2, Y2);
		location[2][2] = target;

		if (locationBool[1][1]) {
			startTileRight.draw(X1, Y1);
		}
		if (locationBool[8][1]) {
			// mDownLeft.draw(X8, Y1);
			mDownRight.draw(X8, Y1);
		}
		if (locationBool[8][2]) {
			// mUpLeft.draw(X8, Y2);
			mDownLeft.draw(X8, Y2);
		}
		if (locationBool[5][2]) {
			mDownRight.draw(X5, Y2);
		}
		if (locationBool[5][8]) {
			// mUpLeft.draw(X5, Y8);
			mDownRight.draw(X5, Y8);
		}
		if (locationBool[4][8]) {
			mUpRight.draw(X4, Y8);
		}
		if (locationBool[4][2]) {
			mDownLeft.draw(X4, Y2);
		}

		generateRotatedAid();
	}

	public static void generateHard1Rotated() {
		powerOff.draw(820, 590);
		startLight = true;
		endTile.draw(X7, Y1);
		location[7][1] = target;

		if (locationBool[3][8]) {
			startTileUp.draw(X3, Y8);
		}

		if (locationBool[2][8]) {
			mUpRight.draw(X2, Y8);
		}
		if (locationBool[2][6]) {
			mDownRight.draw(X2, Y6);
		}
		if (locationBool[7][6]) {
			mDownLeft.draw(X7, Y6);
		}

		if (locationBool[7][7]) {
			mUpLeft.draw(X7, Y7);
		}
		if (locationBool[1][7]) {
			mUpRight.draw(X1, Y7);
		}
		if (locationBool[1][5]) {
			mDownRight.draw(X1, Y5);
		}
		if (locationBool[3][5]) {
			mUpLeft.draw(X3, Y5);
		}
		if (locationBool[3][3]) {
			mDownRight.draw(X3, Y3);
		}
		if (locationBool[4][3]) {
			mDownLeft.draw(X4, Y3);
		}
		if (locationBool[4][4]) {
			mUpLeft.draw(X4, Y4);
		}
		if (locationBool[1][4]) {
			mUpRight.draw(X1, Y4);
		}
		if (locationBool[1][1]) {
			mDownRight.draw(X1, Y1);
		}
		if (locationBool[7][4]) {
			wallTile.draw(X7, Y4);
		}

		if (locationBool[8][3]) {
			mUpRight.draw(X8, Y3);
		}
		if (locationBool[8][5]) {
			mDownLeft.draw(X8, Y5);
		}

		generateRotatedAid();
	}

	public static void generateHard2Rotated() {
		startLight = true;
		powerOff.draw(820, 590);
		endTile.draw(X1, Y7);
		location[1][7] = target;

		if (locationBool[6][3]) {
			startTileUp.draw(X6, Y3);
		}

		if (locationBool[6][5]) {
			mUpRight.draw(X6, Y5);
		}
		if (locationBool[8][5]) {
			mUpLeft.draw(X8, Y5);
		}
		if (locationBool[8][1]) {
			mDownLeft.draw(X8, Y1);
		}
		if (locationBool[5][1]) {
			mDownRight.draw(X5, Y1);
		}
		if (locationBool[5][3]) {
			mUpLeft.draw(X5, Y3);
		}
		if (locationBool[2][3]) {
			mUpRight.draw(X2, Y3);
		}
		if (locationBool[2][1]) {
			mDownRight.draw(X2, Y1);
		}
		if (locationBool[3][1]) {
			mDownLeft.draw(X3, Y1);
		}
		if (locationBool[3][2]) {
			mUpLeft.draw(X3, Y2);
		}
		if (locationBool[1][2]) {
			mDownRight.draw(X1, Y2);
		}
		if (locationBool[1][6]) {
			mUpRight.draw(X1, Y6);
		}
		if (locationBool[6][6]) {
			mDownLeft.draw(X6, Y6);
		}
		if (locationBool[6][8]) {
			mUpLeft.draw(X6, Y8);
		}
		if (locationBool[4][8]) {
			mUpRight.draw(X4, Y8);
		}
		if (locationBool[4][4]) {
			mDownLeft.draw(X4, Y4);
		}
		if (locationBool[3][4]) {
			mDownRight.draw(X3, Y4);
		}
		if (locationBool[3][7]) {
			mUpLeft.draw(X3, Y7);
		}
		if (locationBool[7][3]) {
			mDownRight.draw(X7, Y3);
		}

		generateRotatedAid();
	}

	public static void generateHard3Rotated() {
		startLight = true;
		powerOff.draw(820, 590);
		endTile.draw(X8, Y1);
		location[8][1] = target;

		if (locationBool[1][1]) {
			startTileDown.draw(X1, Y1);
		}

		if (locationBool[1][8]) {
			mUpRight.draw(X1, Y8);
		}
		if (locationBool[2][8]) {
			mUpLeft.draw(X2, Y8);
		}
		if (locationBool[2][5]) {
			mDownRight.draw(X2, Y5);
		}
		if (locationBool[3][5]) {
			mUpLeft.draw(X3, Y5);
		}
		if (locationBool[3][1]) {
			// mDownRight.draw(X3, Y1);
			mDownLeft.draw(X3, Y1);
		}
		if (locationBool[4][1]) {
			mDownLeft.draw(X4, Y1);
		}
		if (locationBool[4][8]) {
			mUpRight.draw(X4, Y8);
		}
		if (locationBool[8][8]) {
			mUpLeft.draw(X8, Y8);
		}
		if (locationBool[8][7]) {
			mDownLeft.draw(X8, Y7);
		}
		if (locationBool[6][7]) {
			// mUpRight.draw(X6, Y7);
			mDownRight.draw(X6, Y7);
		}
		if (locationBool[6][2]) {
			mDownLeft.draw(X6, Y2);
		}
		if (locationBool[5][2]) {
			mUpRight.draw(X5, Y2);
		}
		if (locationBool[5][1]) {
			mDownRight.draw(X5, Y1);
		}
		if (locationBool[8][2]) {
			wallTile.draw(X8, Y2);
		}
		if (locationBool[3][6]) {
			mUpRight.draw(X3, Y6);
		}
		if (locationBool[8][6]) {
			mUpLeft.draw(X8, Y6);
		}
		if (locationBool[5][5]) {
			mUpLeft.draw(X5, Y5);
		}

		generateRotatedAid();
	}

	public static void generateHard4Rotated() {
		startLight = true;
		powerOff.draw(820, 590);
		endTile.draw(X5, Y5);
		location[5][5] = target;

		if (locationBool[4][4]) {
			startTileUp.draw(X4, Y4);
		}

		if (locationBool[4][6]) {
			mUpRight.draw(X4, Y6);
		}
		if (locationBool[6][6]) {
			mUpLeft.draw(X6, Y6);
		}
		if (locationBool[6][4]) {
			mDownRight.draw(X6, Y4);
		}
		if (locationBool[7][4]) {
			mDownLeft.draw(X7, Y4);
		}
		if (locationBool[7][7]) {
			mUpLeft.draw(X7, Y7);
		}
		if (locationBool[3][7]) {
			mUpRight.draw(X3, Y7);
		}
		if (locationBool[3][3]) {
			mDownRight.draw(X3, Y3);
		}
		if (locationBool[8][3]) {
			mUpLeft.draw(X8, Y3);
		}
		if (locationBool[8][2]) {
			mDownLeft.draw(X8, Y2);
		}
		if (locationBool[2][2]) {
			mDownRight.draw(X2, Y2);
		}
		if (locationBool[2][8]) {
			mUpLeft.draw(X2, Y8);
		}
		if (locationBool[1][8]) {
			mUpRight.draw(X1, Y8);
		}
		if (locationBool[1][5]) {
			mDownRight.draw(X1, Y5);
		}
		if (locationBool[4][8]) {
			mDownRight.draw(X4, Y8);
		}
		if (locationBool[8][8]) {
			mUpRight.draw(X8, Y8);
		}
		if (locationBool[8][6]) {
			wallTile.draw(X8, Y6);
		}

		generateRotatedAid();
	}

	public static void generateHard5Rotated() {
		startLight = true;
		powerOff.draw(820, 590);
		endTile.draw(X7, Y3);
		location[7][3] = target;

		if (locationBool[2][5]) {
			startTileUp.draw(X2, Y5);
		}

		if (locationBool[2][4]) {
			mDownRight.draw(X2, Y4);
		}
		if (locationBool[4][4]) {
			mDownLeft.draw(X4, Y4);
		}
		if (locationBool[4][6]) {
			mUpRight.draw(X4, Y6);
		}
		if (locationBool[8][6]) {
			mUpLeft.draw(X8, Y6);
		}
		if (locationBool[8][2]) {
			mDownLeft.draw(X8, Y2);
		}
		if (locationBool[5][2]) {
			mDownRight.draw(X5, Y2);
		}
		if (locationBool[5][7]) {
			mUpLeft.draw(X5, Y7);
		}
		if (locationBool[1][7]) {
			mUpRight.draw(X1, Y7);
		}
		if (locationBool[1][1]) {
			mDownRight.draw(X1, Y1);
		}
		if (locationBool[6][1]) {
			mDownLeft.draw(X6, Y1);
		}
		if (locationBool[6][8]) {
			mUpLeft.draw(X6, Y8);
		}
		if (locationBool[3][8]) {
			mUpRight.draw(X3, Y8);
		}
		if (locationBool[3][3]) {
			mDownRight.draw(X3, Y3);
		}
		if (locationBool[2][2]) {
			mDownRight.draw(X2, Y2);
		}

		generateRotatedAid();
	}

	public static void generateRotatedAid() {
		if (changeLocation) {
			if (Methods.rotateMirrorOnce) {
				int num1 = 260 + (xRotate * 70);
				int num2 = 80 + (yRotate * 70);
				rotateMirror(xRotate, yRotate, num1, num2);
				int hi = location[xRotate][yRotate];
				location[xRotate][yRotate] = locationUpdate(hi);
				Methods.rotateMirrorOnce = false;
			}
		} else {
			while (true) {
				if (location[xRotate][yRotate] == leftUp) {
					mUpLeft.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				} else if (location[xRotate][yRotate] == rightUp) {
					mUpRight.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				} else if (location[xRotate][yRotate] == rightDown) {
					mDownRight.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				} else if (location[xRotate][yRotate] == leftDown) {
					mDownLeft.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				} else if (location[xRotate][yRotate] == startUp) {
					startTileUp.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				} else if (location[xRotate][yRotate] == startRight) {
					startTileRight.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				} else if (location[xRotate][yRotate] == startDown) {
					startTileDown.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				} else if (location[xRotate][yRotate] == startLeft) {
					startTileLeft.draw(260 + (xRotate - 1) * 70, 80 + ((yRotate - 1) * 70));
					break;
				}

			}
			printList();
		}

	}

	public static void generateEasy2() {
		clearArray();
		startTileUp.draw(X3, Y8);
		location[3][8] = startUp;
		startLight = true;

		xStart = X3;
		yStart = Y8;
		arrayX = 3;
		arrayY = 8;
		direction = 0;
		powerOff.draw(820, 590);
		endTile.draw(X6, Y2);
		location[6][2] = target;

		mDownRight.draw(X3, Y1);
		location[3][1] = rightDown;

		// mDownLeft.draw(X8, Y1);
		// location[8][1] = leftDown;
		mDownRight.draw(X8, Y1);
		location[8][1] = rightDown;

		mUpLeft.draw(X8, Y7);
		location[8][7] = leftUp;

		// mUpRight.draw(X2, Y7);
		// location[2][7] = rightUp;
		mDownRight.draw(X2, Y7);
		location[2][7] = rightDown;

		mDownRight.draw(X2, Y2);
		location[2][2] = rightDown;

	}

	public static void generateEasy3() {

		clearArray();
		startTileUp.draw(X3, Y8);
		location[3][8] = startUp;
		powerOff.draw(820, 590);
		startLight = true;
		direction = 0;

		xStart = X3;
		yStart = Y8;
		arrayX = 3;
		arrayY = 8;

		endTile.draw(X5, Y1);
		location[5][1] = target;
		mDownRight.draw(X3, Y6);
		location[3][6] = rightDown;
		// mDownLeft.draw(X5, Y6);
		// location[5][6] = leftDown;
		mDownRight.draw(X5, Y6);
		location[5][6] = rightDown;
		mUpRight.draw(X5, Y8);
		location[5][8] = rightUp;
		// mUpLeft.draw(X8, Y8);
		// location[8][8] = leftUp;
		mDownRight.draw(X8, Y8);
		location[8][8] = rightDown;
		mDownLeft.draw(X8, Y4);
		location[8][4] = leftDown;
		mUpRight.draw(X5, Y4);
		location[5][4] = rightUp;
	}

	public static void generateEasy4() {
		clearArray();
		powerOff.draw(820, 590);
		startLight = true;
		startTileRight.draw(X3, Y5);
		location[3][5] = startRight;

		xStart = X3;
		yStart = Y5;
		arrayX = 3;
		arrayY = 5;

		direction = 1;
		endTile.draw(X6, Y4);
		location[6][4] = target;
		mDownLeft.draw(X7, Y5);
		location[7][5] = leftDown;
		// mUpLeft.draw(X7, Y7);
		// location[7][7]=leftUp;
		mDownRight.draw(X7, Y7);
		location[7][7] = rightDown;
		mDownRight.draw(X3, Y7);
		location[3][7] = rightDown;
		mUpRight.draw(X3, Y8);
		location[3][8] = rightUp;
		// mUpLeft.draw(X8, Y8);
		// location[8][8] = leftUp;
		mUpRight.draw(X8, Y8);
		location[8][8] = rightUp;
		mDownLeft.draw(X8, Y1);
		location[8][1] = leftDown;
		mDownRight.draw(X6, Y1);
		location[6][1] = rightDown;
	}

	public static void generateEasy5() {
		clearArray();
		powerOff.draw(820, 590);
		startTileRight.draw(X1, Y8);
		location[1][8] = startRight;
		startLight = true;

		xStart = X1;
		yStart = Y8;
		arrayX = 1;
		arrayY = 8;

		direction = 1;
		endTile.draw(X4, Y4);
		location[4][4] = target;
		mUpLeft.draw(X8, Y8);
		location[8][8] = leftUp;
		// mDownLeft.draw(X8, Y1);
		// location[8][1] = leftDown;
		mDownRight.draw(X8, Y1);
		location[8][1] = rightDown;
		mDownRight.draw(X1, Y1);
		location[1][1] = rightDown;
		mUpRight.draw(X1, Y7);
		location[1][7] = rightUp;
		mUpLeft.draw(X7, Y7);
		location[7][7] = leftUp;
		// mDownLeft.draw(X7, Y2);
		// location[7][2] =leftDown;
		mUpLeft.draw(X7, Y2);
		location[7][2] = leftUp;
		mDownRight.draw(X2, Y2);
		location[2][2] = rightDown;
		mUpRight.draw(X2, Y6);
		location[2][6] = rightUp;
		mUpLeft.draw(X6, Y6);
		location[6][6] = leftUp;
		mDownLeft.draw(X6, Y3);
		location[6][3] = leftDown;
		mDownRight.draw(X3, Y3);
		location[3][3] = rightDown;
		mUpRight.draw(X3, Y5);
		location[3][5] = rightUp;
		mUpLeft.draw(X5, Y5);
		location[5][5] = leftUp;
		mDownLeft.draw(X5, Y4);
		location[5][4] = leftDown;
	}

	public static void generateMedium1() {

		clearArray();
		powerOff.draw(820, 590);
		startTileUp.draw(X1, Y8);
		location[1][8] = startUp;
		startLight = true;

		direction = 0;
		xStart = X1;
		yStart = Y8;
		arrayX = 1;
		arrayY = 8;

		endTile.draw(X3, Y7);
		location[3][7] = target;

		mDownRight.draw(X1, Y1);
		location[1][1] = rightDown;
		// mDownLeft.draw(X2, Y1);
		// location[2][1] = leftDown;
		mUpLeft.draw(X2, Y1);
		location[2][1] = leftUp;
		// mUpRight.draw(X2, Y8);
		// location[2][8] = rightUp;
		mUpLeft.draw(X2, Y8);
		location[2][8] = leftUp;
		mUpLeft.draw(X8, Y8);
		location[8][8] = leftUp;
		// mDownLeft.draw(X8, Y7);
		// location[8][7] = leftDown;
		mDownRight.draw(X8, Y7);
		location[8][7] = rightDown;

	}

	public static void generateMedium2() {
		clearArray();
		powerOff.draw(820, 590);
		startTileLeft.draw(X4, Y8);
		location[4][8] = startLeft;
		startLight = true;

		direction = 3;
		xStart = X4;
		yStart = Y8;
		arrayX = 4;
		arrayY = 8;

		endTile.draw(X4, Y1);
		location[4][1] = target;
		mUpRight.draw(X1, Y8);
		location[1][8] = rightUp;
		// mDownRight.draw(X1, Y7);
		// location[1][7] = rightDown;
		mDownLeft.draw(X1, Y7);
		location[1][7] = leftDown;
		mDownLeft.draw(X8, Y7);
		location[8][7] = leftDown;
		// mUpLeft.draw(X8, Y8);
		// location[8][8] = leftUp;
		mDownRight.draw(X8, Y8);
		location[8][8] = rightDown;
		mUpRight.draw(X5, Y8);
		location[5][8] = rightUp;
		// mDownRight.draw(X5, Y1);
		// location[5][1] = rightDown;
		mDownLeft.draw(X5, Y1);
		location[5][1] = leftDown;
		mDownLeft.draw(X8, Y1);
		location[8][1] = leftDown;
		mUpLeft.draw(X8, Y2);
		location[8][2] = leftUp;
		mUpRight.draw(X1, Y2);
		location[1][2] = rightUp;
		mDownRight.draw(X1, Y1);
		location[1][1] = rightDown;

		wallTile.draw(X4, Y4);
		location[4][4] = wall;
	}

	public static void generateMedium3() {
		clearArray();
		powerOff.draw(820, 590);

		startLight = true;
		startTileLeft.draw(X8, Y1);
		location[8][1] = startLeft;
		direction = 3;
		xStart = X8;
		yStart = Y1;
		arrayX = 8;
		arrayY = 1;

		endTile.draw(X7, Y2);
		location[7][2] = target;
		mDownRight.draw(X1, Y1);
		location[1][1] = rightDown;
		// mUpRight.draw(X1, Y8);
		// location[1][8] = rightUp;
		mDownRight.draw(X1, Y8);
		location[1][8] = rightDown;
		// mUpLeft.draw(X8, Y8);
		// location[8][8] = leftUp;
		mUpRight.draw(X8, Y8);
		location[8][8] = rightUp;
		mDownLeft.draw(X8, Y4);
		location[8][4] = leftDown;
		mDownRight.draw(X4, Y4);
		location[4][4] = rightDown;
		mUpRight.draw(X4, Y5);
		location[4][5] = rightUp;
		// mDownLeft.draw(X7, Y5);
		// location[7][5] = leftDown;
		mUpRight.draw(X7, Y5);
		location[7][5] = rightUp;
		mUpLeft.draw(X7, Y7);
		location[7][7] = leftUp;
		mUpRight.draw(X2, Y7);
		location[2][7] = rightUp;
		mDownRight.draw(X2, Y2);
		location[2][2] = rightDown;

	}

	public static void generateMedium4() {
		clearArray();
		powerOff.draw(820, 590);
		startTileUp.draw(X1, Y8);
		location[1][8] = startUp;
		direction = 0;
		startLight = true;

		xStart = X1;
		yStart = Y8;
		arrayX = 1;
		arrayY = 8;

		endTile.draw(X8, Y8);
		location[8][8] = target;
		// mDownRight.draw(X1, Y1);
		// location[1][1] = rightDown;
		mUpLeft.draw(X1, Y1);
		location[1][1] = leftUp;
		mDownLeft.draw(X2, Y1);
		location[2][1] = leftDown;
		// mUpRight.draw(X2, Y8);
		// location[2][8] = rightUp;
		mDownRight.draw(X2, Y8);
		location[2][8] = rightDown;
		mUpLeft.draw(X3, Y8);
		location[3][8] = leftUp;
		mDownRight.draw(X3, Y5);
		location[3][5] = rightDown;
		mDownLeft.draw(X6, Y5);
		location[6][5] = leftDown;
		// mUpRight.draw(X6, Y8);
		// location[6][8] = rightUp;
		mUpLeft.draw(X6, Y8);
		location[6][8] = leftUp;
		mUpLeft.draw(X7, Y8);
		location[7][8] = leftUp;
		mDownRight.draw(X7, Y1);
		location[7][1] = rightDown;
		mDownLeft.draw(X8, Y1);
		location[8][1] = leftDown;

	}

	public static void generateMedium5() {
		clearArray();
		powerOff.draw(820, 590);
		startTileRight.draw(X1, Y1);
		location[1][1] = startRight;
		startLight = true;
		direction = 1;

		xStart = X1;
		yStart = Y1;
		arrayX = 1;
		arrayY = 1;

		endTile.draw(X2, Y2);
		location[2][2] = target;
		// mDownLeft.draw(X8, Y1);
		// location[8][1] = leftDown;
		mDownRight.draw(X8, Y1);
		location[8][1] = rightDown;
		// mUpLeft.draw(X8, Y2);
		// location[8][2] = leftUp;
		mDownLeft.draw(X8, Y2);
		location[8][2] = leftDown;
		mDownRight.draw(X5, Y2);
		location[5][2] = rightDown;
		// mUpLeft.draw(X5, Y8);
		// location[5][8] = leftUp;
		mDownRight.draw(X5, Y8);
		location[5][8] = rightDown;
		mUpRight.draw(X4, Y8);
		location[4][8] = rightUp;
		mDownLeft.draw(X4, Y2);
		location[4][2] = leftDown;
	}

	public static void generateHard1() {
		clearArray();
		powerOff.draw(820, 590);
		startTileUp.draw(X3, Y8);
		location[3][8] = startUp;
		startLight = true;

		direction = 3;

		xStart = X3;
		yStart = Y8;
		arrayX = 3;
		arrayY = 8;

		endTile.draw(X7, Y1);
		location[7][1] = target;
		mUpRight.draw(X2, Y8);
		location[2][8] = rightUp;
		mDownRight.draw(X2, Y6);
		location[2][6] = rightDown;
		mDownLeft.draw(X7, Y6);
		location[7][6] = leftDown;
		mUpLeft.draw(X7, Y7);
		location[7][7] = leftUp;
		mUpRight.draw(X1, Y7);
		location[1][7] = rightUp;
		mDownRight.draw(X1, Y5);
		location[1][5] = rightDown;
		mUpLeft.draw(X3, Y5);
		location[3][5] = leftUp;
		mDownRight.draw(X3, Y3);
		location[3][3] = rightDown;
		mDownLeft.draw(X4, Y3);
		location[4][3] = leftDown;
		mUpLeft.draw(X4, Y4);
		location[4][4] = leftUp;
		mUpRight.draw(X1, Y4);
		location[1][4] = rightUp;
		mDownRight.draw(X1, Y1);
		location[1][1] = rightDown;
		wallTile.draw(X7, Y4);
		location[7][4] = wall;
		// Distraction tiles TODO add more also change tiles
		mUpRight.draw(X8, Y3);
		location[8][3] = rightUp;
		mDownLeft.draw(X8, Y5);
		location[8][5] = leftDown;
	}

	public static void generateHard2() {
		clearArray();
		powerOff.draw(820, 590);
		startTileUp.draw(X6, Y3);
		location[6][3] = startUp;
		startLight = true;

		direction = 2;

		xStart = X6;
		yStart = Y3;
		arrayX = 6;
		arrayY = 3;

		endTile.draw(X1, Y7);
		location[1][7] = target;
		mUpRight.draw(X6, Y5);
		location[6][5] = rightUp;
		mUpLeft.draw(X8, Y5);
		location[8][5] = leftUp;
		mDownLeft.draw(X8, Y1);
		location[8][1] = leftDown;
		mDownRight.draw(X5, Y1);
		location[5][1] = rightDown;
		mUpLeft.draw(X5, Y3);
		location[5][3] = leftUp;
		mUpRight.draw(X2, Y3);
		location[2][3] = rightUp;
		mDownRight.draw(X2, Y1);
		location[2][1] = rightDown;
		mDownLeft.draw(X3, Y1);
		location[3][1] = leftDown;
		mUpLeft.draw(X3, Y2);
		location[3][2] = leftUp;
		mDownRight.draw(X1, Y2);
		location[1][2] = rightDown;
		mUpRight.draw(X1, Y6);
		location[1][6] = rightUp;
		mDownLeft.draw(X6, Y6);
		location[6][6] = leftDown;
		mUpLeft.draw(X6, Y8);
		location[6][8] = leftUp;
		mUpRight.draw(X4, Y8);
		location[4][8] = rightUp;
		mDownLeft.draw(X4, Y4);
		location[4][4] = leftDown;
		mDownRight.draw(X3, Y4);
		location[3][4] = rightDown;
		mUpLeft.draw(X3, Y7);
		location[3][7] = leftUp;
		// TODO add distracting mirrors
		mDownRight.draw(X7, Y3);
		location[7][3] = rightDown;
	}

	public static void generateHard3() {
		clearArray();
		powerOff.draw(820, 590);
		startTileDown.draw(X1, Y1);
		location[1][1] = startDown;
		startLight = true;

		direction = 2;

		xStart = X1;
		yStart = Y1;
		arrayX = 1;
		arrayY = 1;

		endTile.draw(X8, Y1);
		location[8][1] = target;
		mUpRight.draw(X1, Y8);
		location[1][8] = rightUp;
		mUpLeft.draw(X2, Y8);
		location[2][8] = leftUp;
		mDownRight.draw(X2, Y5);
		location[2][5] = rightDown;
		mUpLeft.draw(X3, Y5);
		location[3][5] = leftUp;
		// mDownRight.draw(X3, Y1);
		// location[3][1] = rightDown;
		mDownLeft.draw(X3, Y1);
		location[3][1] = leftDown;
		mDownLeft.draw(X4, Y1);
		location[4][1] = leftDown;
		mUpRight.draw(X4, Y8);
		location[4][8] = rightUp;
		mUpLeft.draw(X8, Y8);
		location[8][8] = leftUp;
		mDownLeft.draw(X8, Y7);
		location[8][7] = leftDown;
		// mUpRight.draw(X6, Y7);
		// location[6][7] = rightUp;
		mDownRight.draw(X6, Y7);
		location[6][7] = rightDown;
		mDownLeft.draw(X6, Y2);
		location[6][2] = leftDown;
		mUpRight.draw(X5, Y2);
		location[5][2] = rightUp;
		mDownRight.draw(X5, Y1);
		location[5][1] = rightDown;
		wallTile.draw(X8, Y2);
		location[8][2] = wall;
		// TODO add distracting mirrors
		mUpRight.draw(X3, Y6);
		location[3][6] = rightUp;
		mUpLeft.draw(X8, Y6);
		location[8][6] = leftUp;
		mUpLeft.draw(X5, Y5);
		location[5][5] = leftUp;

	}

	public static void generateHard4() {
		clearArray();
		powerOff.draw(820, 590);
		startTileUp.draw(X4, Y4);
		location[4][4] = startUp;
		startLight = true;
		direction = 2;

		xStart = X4;
		yStart = Y4;
		arrayX = 4;
		arrayY = 4;

		endTile.draw(X5, Y5);
		location[5][5] = target;
		mUpRight.draw(X4, Y6);
		location[4][6] = rightUp;
		mUpLeft.draw(X6, Y6);
		location[6][6] = leftUp;
		mDownRight.draw(X6, Y4);
		location[6][4] = rightDown;
		mDownLeft.draw(X7, Y4);
		location[7][4] = leftDown;
		mUpLeft.draw(X7, Y7);
		location[7][7] = leftUp;
		mUpRight.draw(X3, Y7);
		location[3][7] = rightUp;
		mDownRight.draw(X3, Y3);
		location[3][3] = rightDown;
		mUpLeft.draw(X8, Y3);
		location[8][3] = leftUp;
		mDownLeft.draw(X8, Y2);
		location[8][2] = leftDown;
		mDownRight.draw(X2, Y2);
		location[2][2] = rightDown;
		mUpLeft.draw(X2, Y8);
		location[2][8] = leftUp;
		mUpRight.draw(X1, Y8);
		location[1][8] = rightUp;
		mDownRight.draw(X1, Y5);
		location[1][5] = rightDown;
		// TODO add distracting mirrors and walls
		mDownRight.draw(X4, Y8);
		location[4][8] = rightDown;
		mUpRight.draw(X8, Y8);
		location[8][8] = rightUp;
		wallTile.draw(X8, Y6);
		location[8][6] = wall;
	}

	public static void generateHard5() {
		clearArray();
		powerOff.draw(820, 590);
		startTileUp.draw(X2, Y5);
		location[2][5] = startUp;
		startLight = true;
		direction = 0;

		xStart = X2;
		yStart = Y5;
		arrayX = 2;
		arrayY = 5;

		endTile.draw(X7, Y3);
		location[7][3] = target;
		mDownRight.draw(X2, Y4);
		location[2][4] = rightDown;
		mDownLeft.draw(X4, Y4);
		location[4][4] = leftDown;
		mUpRight.draw(X4, Y6);
		location[4][6] = rightUp;
		mUpLeft.draw(X8, Y6);
		location[8][6] = leftUp;
		mDownLeft.draw(X8, Y2);
		location[8][2] = leftDown;
		mDownRight.draw(X5, Y2);
		location[5][2] = rightDown;
		mUpLeft.draw(X5, Y7);
		location[5][7] = leftUp;
		mUpRight.draw(X1, Y7);
		location[1][7] = rightUp;
		mDownRight.draw(X1, Y1);
		location[1][1] = rightDown;
		mDownLeft.draw(X6, Y1);
		location[6][1] = leftDown;
		mUpLeft.draw(X6, Y8);
		location[6][8] = leftUp;
		mUpRight.draw(X3, Y8);
		location[3][8] = rightUp;
		mDownRight.draw(X3, Y3);
		location[3][3] = rightDown;
		// TODO add distracting mirrors and walls
		mDownRight.draw(X2, Y2);
		location[2][2] = rightDown;
	}

	// Clear all the mirrors from the array
	public static void clearArray() {
		int rows = location.length;
		int col = location[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				location[i][j] = 0;

			}
		}
	}

	public static void rotateMirror(int x, int y, int aX, int aY) {
		while (rotateMirrorOnce) {

			if (location[x][y] == leftUp) {
				// mUpRight.draw(aX, aY);
				list.add(new Cell(aX, aY, rightUp));
				rotateMirrorOnce = false;
				break;
			}
			if (location[x][y] == rightUp) {
				list.add(new Cell(aX, aY, rightDown));
				// mDownRight.draw(aX, aY);
				rotateMirrorOnce = false;
				break;
			}
			if (location[x][y] == rightDown) {
				list.add(new Cell(aX, aY, leftDown));
				// mDownLeft.draw(aX, aY);
				rotateMirrorOnce = false;
				break;
			}
			if (location[x][y] == leftDown) {
				// mUpLeft.draw(aX, aY);
				list.add(new Cell(aX, aY, leftUp));
				rotateMirrorOnce = false;
				break;
			}
			if (location[x][y] == startUp) {
				list.add(new Cell(aX, aY, startRight));
				// startTileRight.draw(aX, aY);
				direction = 1;
				rotateMirrorOnce = false;
				break;
			}
			if (location[x][y] == startRight) {
				// startTileDown.draw(aX, aY);
				list.add(new Cell(aX, aY, startDown));
				direction = 2;
				rotateMirrorOnce = false;
				break;
			}
			if (location[x][y] == startDown) {
				list.add(new Cell(aX, aY, startLeft));
				// startTileLeft.draw(aX, aY);
				direction = 3;
				rotateMirrorOnce = false;
				break;
			}
			if (location[x][y] == startLeft) {
				list.add(new Cell(aX, aY, startUp));
				// startTileUp.draw(aX, aY);
				direction = 0;
				rotateMirrorOnce = false;
				break;
			}
		}
	}

	private static void printList() {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			//System.out.println("Cell " + i);
			Cell temp = list.get(i);
			if (temp.getDirection() == leftUp) {
				mUpLeft.draw(temp.getX(), temp.getY());
			} else if (temp.getDirection() == rightUp) {
				mUpRight.draw(temp.getX(), temp.getY());
			} else if (temp.getDirection() == leftDown) {
				mDownLeft.draw(temp.getX(), temp.getY());
			} else if (temp.getDirection() == rightDown) {
				mDownRight.draw(temp.getX(), temp.getY());
			} else if (temp.getDirection() == startUp) {
				startTileUp.draw(temp.getX(), temp.getY());
			} else if (temp.getDirection() == startRight) {
				startTileRight.draw(temp.getX(), temp.getY());
			} else if (temp.getDirection() == startDown) {
				startTileDown.draw(temp.getX(), temp.getY());
			} else if (temp.getDirection() == startLeft) {
				startTileLeft.draw(temp.getX(), temp.getY());
			}

		}
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	private static int locationUpdate(int i) {
		if (i == leftUp) {
			changeLocation = false;
			return rightUp;
		}
		else if (i == rightUp) {
			changeLocation = false;
			return rightDown;
		}
		else if (i == rightDown) {
			changeLocation = false;
			return leftDown;
		}
		else if (i == leftDown) {
			changeLocation = false;
			return leftUp;
		}
		else if (i == startUp) {
			changeLocation = false;
			return startRight;
		}
		else if (i == startRight) {
			changeLocation = false;
			return startDown;
		}
		else if (i == startDown) {
			changeLocation = false;
			return startLeft;
		}
		else if (i == startLeft) {
			changeLocation = false;
			return startUp;
		}
		else if (i == vertLight) {
			changeLocation = false;
			return vertLight;
		}
		else if (i == horizLight) {
			changeLocation = false;
			return horizLight;
		}
		return i;
	}

	public static void shootUp(int direction, int startX, int startY, int aX, int aY) {
		if (startLight) {
			// aX -=1;
			startLightUp.draw(startX, startY);
			startLight = false;
			startY -= 70;
			aY -= 1;
		}
		while (aY > 0) {
			if (location[aX][aY] == leftDown) {
				mDownLeftLight.draw(startX, startY);
				shootLeft(LEFT, startX - 70, startY, aX - 1, aY);
				break;
			} else if (location[aX][aY] == rightDown) {
				mDownRightLight.draw(startX, startY);
				shootRight(RIGHT, startX + 70, startY, aX + 1, aY);
				break;
			} else if (location[aX][aY] == wall) { // Don't need this? bc of
													// location == 0 one?
				break;
			} else if (location[aX][aY] == target) {
				endLightDown.draw(startX, startY);
				levelComplete.draw(0, 0);
				break;
			} else if (location[aX][aY] == horizLight || location[aX][aY] == cross) {
				beamCross.draw(startX, startY);
				location[aX][aY] = cross;
			} else if (location[aX][aY] == 0 || location[aX][aY] == vertLight) {
				beamVertical.draw(startX, startY);
				location[aX][aY] = vertLight;
			} else if (location[aX][aY] == rightUp || location[aX][aY] == leftUp) {
				break;
			}
			startY -= 70;
			aY -= 1;
		}
	}

	public static void shootRight(int direction, int startX, int startY, int aX, int aY) {
		// If this is the first move
		//
		if (startLight) {
			// aX -=1;
			startLightRight.draw(startX, startY);
			startLight = false;
			startX += 70;
			aX += 1;
		}

		while (aX < 9) {
			if (location[aX][aY] == leftUp) {
				mUpLeftLight.draw(startX, startY);
				shootUp(UP, startX, startY - 70, aX, aY - 1);
				break;
			} else if (location[aX][aY] == leftDown) {
				mDownLeftLight.draw(startX, startY);
				shootDown(DOWN, startX, startY + 70, aX, aY + 1);

				break;
			} else if (location[aX][aY] == wall) {
				// TODO wall stuffffff
				break;
			} else if (location[aX][aY] == target) {
				endLightLeft.draw(startX, startY);
				levelComplete.draw(0, 0);
				break;
				// LEVEL COMPLETED!
			} else if (location[aX][aY] == vertLight || location[aX][aY] == cross) {
				beamCross.draw(startX, startY);
				location[aX][aY] = cross;

			} else if (location[aX][aY] == 0 || location[aX][aY] == horizLight) {
				beamHorizontal.draw(startX, startY);
				location[aX][aY] = horizLight;
			} else if (location[aX][aY] == rightUp || location[aX][aY] == rightDown) {
				break;
			}
			startX += 70;
			aX += 1;

		}

	}

	public static void shootDown(int direction, int startX, int startY, int aX, int aY) {
		if (startLight) {
			// aX -=1;
			startLightDown.draw(startX, startY);
			startLight = false;
			startY += 70;
			aY += 1;
		}
		while (aY < 9) {
			if (location[aX][aY] == leftUp) {
				mUpLeftLight.draw(startX, startY);
				shootLeft(LEFT, startX - 70, startY, aX - 1, aY);
				break;
			} else if (location[aX][aY] == rightUp) {
				mUpRightLight.draw(startX, startY);
				shootRight(RIGHT, startX + 70, startY, aX + 1, aY);
				break;
			} else if (location[aX][aY] == wall) {
				break;
			} else if (location[aX][aY] == target) {
				endLightUp.draw(startX, startY);
				levelComplete.draw(0, 0);
				break;
			} else if (location[aX][aY] == horizLight || location[aX][aY] == cross) {
				beamCross.draw(startX, startY);
				location[aX][aY] = cross;
			} else if (location[aX][aY] == 0 || location[aX][aY] == vertLight) {
				beamVertical.draw(startX, startY);
				location[aX][aY] = vertLight;
			} else if (location[aX][aY] == leftDown || location[aX][aY] == rightDown) {
				break;
			}
			startY += 70;
			aY += 1;

		}
	}

	public static void shootLeft(int direction, int startX, int startY, int aX, int aY) {
		if (startLight) {
			startLightLeft.draw(startX, startY);
			startLight = false;
			startX -= 70;
			aX -= 1;
		}
		while (aX > 0) {
			if (location[aX][aY] == rightUp) {
				mUpRightLight.draw(startX, startY);
				shootUp(UP, startX, startY - 70, aX, aY - 1);
				break;
			} else if (location[aX][aY] == rightDown) {
				mDownRightLight.draw(startX, startY);
				shootDown(DOWN, startX, startY + 70, aX, aY + 1);

				break;
			} else if (location[aX][aY] == wall) {
				// TODO wall stuffffff
				return;
			} else if (location[aX][aY] == target) {
				endLightRight.draw(startX, startY);
				levelComplete.draw(0, 0);
				// LEVEL COMPLETED!
				break;
			} else if (location[aX][aY] == vertLight || location[aX][aY] == cross) {
				beamCross.draw(startX, startY);
				location[aX][aY] = cross;
			} else if (location[aX][aY] == 0 || location[aX][aY] == horizLight) {
				beamHorizontal.draw(startX, startY);
				location[aX][aY] = horizLight;
			} else if (location[aX][aY] == leftUp || location[aX][aY] == leftDown) {
				break;
			}

			startX -= 70;
			aX -= 1;

		}

	}

	/**
	 * During the rotation of the mirrors, it takes in the mouse position on the
	 * Y axis and returns the number for int[][] location[][y]
	 * 
	 * @param yPos
	 * @return
	 */
	public static int findYRotate(int yPos) {
		int num = 1;

		if (yPos >= 490) {
			return num;
		} else {
			num += findYRotate(yPos + 70);
		}
		return num;
	}

	public static int findXRotate(int xPos) {
		int num = 1;

		if (xPos <= 70) {
			return num;
		} else {
			num += findXRotate(xPos - 70);
		}
		return num;
	}
}
