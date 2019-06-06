package culminating;

import java.util.Random;

public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;

	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
		
		for (int i = 9; i < 13; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.WATER); // no color
			}
		}
		
		board[14][7] = new Cell(CellState.P1);
		board[0][7] = new Cell(CellState.FINISH);
		
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getCols(){
		return cols;
	}
	

	public boolean isValid(int x, int y){
		return (x>=0 && x < rows) && (y>=0 && y < cols);
	}
	
	
	public Cell getCell(int x, int y) {
		return board[x][y];
	}
	
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void makeCars(int i, int j){
		board[i][j] = new Cell(CellState.CAR);	
	}
	

}
