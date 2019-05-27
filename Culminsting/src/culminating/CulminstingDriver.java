package culminating;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import culminating.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import culminating.Board;

public class CulminstingDriver extends Application {
	private static final int      KEYBOARD_MOVEMENT_DELTA = 30;
	final static int ROWS = 15;
	final static int COLS = 15;
	
	static int px = 7;
	static int py = 14;
	static int lives = 5;
	String direction = "";
	
	boolean done = false;
	
	static Board board = new Board(ROWS, COLS);
	static Button[][] slots = new Button[ROWS][COLS];
	final static Text text = new Text();
	
	public static void main(String[] args) throws InterruptedException {
		
		launch(args);
		
	}
	
	
	
	@Override public void start(Stage stage) throws Exception {
		final int WIDTH = 750;
		final int HEIGHT = 750;
	    final int BUTTON_WIDTH = 100;
		final int BUTTON_HEIGHT = (HEIGHT - 80) / ROWS;
		
		VBox layout = new VBox();

		HBox selectorsROW1 = new HBox();
		selectorsROW1.setPadding(new Insets(20, 20, 0, WIDTH/2 + BUTTON_WIDTH));
		HBox selectorsROW2 = new HBox();
		selectorsROW2.setPadding(new Insets(0, 20, 20, WIDTH/2));
			
		Button btnUP = new Button();
		btnUP.setStyle("-fx-base: #000000;");
		btnUP.setPrefSize(WIDTH / 8, BUTTON_HEIGHT * 2);
		
		Button btnRIGHT = new Button();
		btnRIGHT.setStyle("-fx-base: #000000;");
		btnRIGHT.setPrefSize(WIDTH / 8, BUTTON_HEIGHT * 2);
		
		Button btnDOWN = new Button();
		btnDOWN.setStyle("-fx-base: #000000;");
		btnDOWN.setPrefSize(WIDTH / 8, BUTTON_HEIGHT * 2);
		
		Button btnLEFT = new Button();
		btnLEFT.setStyle("-fx-base: #000000;");
		btnLEFT.setPrefSize(WIDTH / 8, BUTTON_HEIGHT * 2);
		
				
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new Button();
				slots[i][j].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
				slots[i][j].setStyle("-fx-base: #000000;");
			}
		}
		
		
		board.display();
		
			
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		
		
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				grid.add(slots[i][j], j, i);
			}
		}
		
		
		
		btnUP.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				direction = "UP";
				try {
					updateBoard(direction);
					updateBoard2(board, slots);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnRIGHT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				direction = "RIGHT";
				try {
					updateBoard(direction);
					updateBoard2(board, slots);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnDOWN.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				direction = "DOWN";
				try {
					updateBoard(direction);
					updateBoard2(board, slots);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnLEFT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				direction = "LEFT";
				try {
					updateBoard(direction);
					updateBoard2(board, slots);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		updateBoard2(board, slots);
	
			
		selectorsROW1.getChildren().addAll(btnUP);
		layout.getChildren().add(selectorsROW1);
		
		selectorsROW2.getChildren().addAll(btnLEFT, btnDOWN, btnRIGHT);
		layout.getChildren().add(selectorsROW2);
		
		layout.getChildren().add(grid);
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.show();
	  }
	
	private void updateBoard2(Board board, Button[][] slots) {
				
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				switch (board.getCell(i, j).getState()) {
				case EMPTY:
					slots[i][j].setStyle("-fx-base: #ffffff;");
					break;
				case WATER:
					slots[i][j].setStyle("-fx-base: #0000ff;");
					break;
				case P1:
					slots[i][j].setStyle("-fx-base: #00ff00;");
					break;
				case FINISH:
					slots[i][j].setStyle("-fx-base: #ffff00;");
					break;
				case LOG:
					slots[i][j].setStyle("-fx-base: #ffff00;");
					break;
				}
			}
		}
	}
	
	public static void updateBoard(String direction) throws InterruptedException {
		
		
		
		board.display();
		
		board.getCell(py, px).setState(CellState.EMPTY);
		
		if(py > 0){
			if(direction.equals("UP")) {
				if(board.getCell(py-1, px).getState() == CellState.WATER) {
					hurt();
				}
				else{
					py --;
				}
			}
		}
		if(px < COLS-1){
			if(direction.equals("RIGHT")) {
				if(board.getCell(py, px+1).getState() == CellState.WATER) {
					hurt();
				}
				else{
					px ++;
				}
			}
		}
		if(py < ROWS-1) {
			if (direction.equals("DOWN")) {
				if(board.getCell(py+1, px).getState() == CellState.WATER) {
					hurt();
				}
				else{
					py ++;
				}
			}
		}
		
		if(px > 0) { 
			if(direction.equals("LEFT")) {
				if(board.getCell(py, px-1).getState() == CellState.WATER) {
					hurt();
				}
				else{
					px --;
				}
			}
		}
		
		
		board.getCell(py, px).setState(CellState.P1);
	}
	
	
	
	
	public static void hurt() {
		lives--;
		px = 7;
		py = 14;
		System.out.println(lives + " lives remaining");
	}
	
	public static boolean lose(boolean done) {
		if(lives == 0) {
			done = true;
			System.out.println("You lose.");
		}
		return done;
	}


}