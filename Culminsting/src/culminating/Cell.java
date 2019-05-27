package culminating;

public class Cell {
	private CellState state;
	
	
	public Cell(CellState cs) {
		state = cs;
		
	}
	

	
	public void setState (CellState cs){
		state = cs;
	}
	
	public CellState getState() {
		return state;
	}

	public String toString() {
		switch (state) {
		case P1:
			return "O";
		case WATER:
			return "W";
		case LOG:
			return "L";
		case EMPTY:
			return ".";
		case FINISH:
			return "F";
		default:
			return ".";
		}
	}
}
