
public class Connect4{

	private int[][] board;
	private int turn;
	private int turnNumber;

	public Connect4 () {
		board = new int[6][7];
		turn = 1;
		turnNumber = 1;
	}

	public String checkGameOver(){
		//Checking for vertical wins:
		for (int col = 0; col < board[0].length; col++){
			for (int row = 0; row < 3; row++){
				int sum = board[row][col] + board[row+1][col] + board[row+2][col] + board[row+3][col];
				if (sum == 4)
					return "Player 1 has won!";
				if (sum == -4)
					return "Player 2 has won!";
			}
		}
		//Check for horizontal wins:
		for (int[] row : board){
			for (int col = 0; col < 4; col++){
				int sum = row[col] + row[col+1] + row[col+2] + row[col+3];
				if (sum == 4)
					return "Player 1 has won!";
				if (sum == -4)
					return "Player 2 has won!";
			}
		}
		//Check for down and right diagonal wins:
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 4; col++){
				int sum = board[row][col] + board[row+1][col+1] + board[row+2][col+2] + board[row+3][col+3];
				if (sum == 4)
					return "Player 1 has won!";
				if (sum == -4)
					return "Player 2 has won!";
			}
		}
		//Check for down and left diagonal wins:
		for (int row = 0; row < 3; row++){
			for (int col = 3; col < board[0].length; col++){
				int sum = board[row][col] + board[row+1][col-1] + board[row+2][col-2] + board[row+3][col-3];
				if (sum == 4)
					return "Player 1 has won!";
				if (sum == -4)
					return "Player 2 has won!";
			}
		}
		if (turnNumber == 42){
			return "It is a tie!";
		}
		//if the game is not over
		return null;
	}

	public String getTurnDirections(){
		int player = turn;
		if (player == -1){
			player = 2;
		}
		return "Player " + player + ", please select a column (1-7) that is empty.";
	}

	public static String getDirections(){
		return "Connect Four (also known as Four Up, Plot Four, Find Four, Four in a Row, Drop Four, and Gravitrips in the Soviet Union) is a two-player connection board game, in which the players take turns dropping tokens into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the lowest available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own tokens.";
	}

	public void takeTurn(String input){
		//ensure it is a 1-7
		if (input.compareTo("1")<0 || input.compareTo("7")>0 || input.length() != 1){
			return;
		}
		int col = Integer.parseInt(input) - 1;
		//loop through rows to see where there is space in that column
		//if space, store the turn and switch turns
		//if no space, do nothing.
		for (int row = board.length - 1; row > -1; row--){
			if (board[row][col] == 0){
				board[row][col] = turn;
				turn *= -1;
				turnNumber++;
				return;
			}
		}

	}

	public String getBoard(){
		String toReturn = "";
		for (int[] row : board ){
			toReturn += "-----------------------------\n| ";
			for (int piece : row){
				if (piece == -1){
					piece = 2;
				}
				toReturn += piece + " | ";
			}
			toReturn += "\n";
		}
		toReturn += "-----------------------------";
		return toReturn;
	}



}
