package culminating;

public class Car {
	
	private static int direction;
	private static int x;
	private static int y;
	
	public Car(int direct, int row, int col) {
		direction = direct;
		x = col;
		y = row;
	}
	
	
	public int getDirection(){
		return direction;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int n){
		x = n;
	}
	
	public void setY(int n){
		y = n;
	}
	
		
}
