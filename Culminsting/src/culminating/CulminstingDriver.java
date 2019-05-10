package culminating;
import java.util.Scanner;

import culminating.Board;

public class CulminstingDriver {

	public static void main(String[] args) {

		final int ROWS = 7;
		final int COLS = 7;
		int px = 4;
		int py = 4;
		
		Board board = new Board(ROWS, COLS);
		
		boolean done = false;
		
		board.getCell(px, py).setState(CellState.P1);
		
		while(!done) {
			
			board.getCell(py, px).setState(CellState.EMPTY);
			
			int direction = getInput();
				
			if(py > 0){
				if(direction == 5) {
					py --;
				}
			}
			if(px < COLS-1){
				if(direction == 3) {
					px ++;
				}
			}
			if(py < ROWS-1) {
				if (direction == 2) {
					py ++;
				}				
			}
				
			if(px > 0) { 
				if(direction == 1) {
					px --;
				}
			}
			
			
			
			board.getCell(py, px).setState(CellState.P1);
			board.display();
		}

	}
	/*
	private static int getInput() {
		boolean valid = false;
		int input = 0;
		Scanner in = new Scanner(System.in);
		
		while(!valid) {
			System.out.print("input pls:");
			if(in.hasNextInt()) {
				input=in.nextInt();
				if(input<1 || input >7) {
					in.nextLine();
					System.out.println("...");
				}
				else if(input == 1 || input == 2 || input == 3 || input == 5){
					valid=true;
				}
			}
			else {
				in.nextLine();
				System.out.println("...");
			}
		}
		return input;
	}
	*/
	
	private static int getInput() {
		
		int input = 0;
		Scanner in = new Scanner(System.in);
		
		
		System.out.print("input pls:");
		if(in.hasNextInt()) {
			input=in.nextInt();
			if(input<1 || input >7) {
				in.nextLine();
				System.out.println("...");
			}
			else if(input == 1 || input == 2 || input == 3 || input == 5){
				return input;
			}
		}
		else {
			in.nextLine();
			System.out.println("...");
		}
		
		return 0;
		
	}
}
