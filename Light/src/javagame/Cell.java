package javagame;

public class Cell {
	private int xLocation;
	private int yLocation;
	private int directionNew;
	

	
	public Cell(int x, int y, int direction){
		xLocation = x-70;
		yLocation = y-70;
		directionNew = direction;
	}
	public int getX(){
		return xLocation;

	}
	public int getY(){
		return yLocation;
	}
	public int getDirection(){
		return directionNew;
	}
//	
//	public void projectMirror(){
//		Methods.mDownLeft.draw(x, y);
//	}

}
