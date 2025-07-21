//To do:
//c4 class
	//need a board - 2D array of int  x
	//store turn  x
	//turn counter  x

	//method to return the board x
	//method to take a turn - check if room in the column, place the piece and switch turns x
	//method to check for game over
	//some sort of end game output
	//output for whos turn it is - turn directions & ask for piece
	//check for correct input x
	//directions for the beginning 

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connect4 c4 = new Connect4();
		System.out.println(Connect4.getDirections());
		while (true){
			System.out.println(c4.getBoard());
			System.out.println(c4.getTurnDirections());
			c4.takeTurn(scan.nextLine());
			String isGameOver = c4.checkGameOver();
			if ( isGameOver != null){
				System.out.println(c4.getBoard());
				System.out.println(isGameOver);
				System.out.println("Do you want to play again? (y/n)");
				if (scan.nextLine().equalsIgnoreCase("n")){
					return;
				}
				//if they want to play again, we should reset the game.
				c4 = new Connect4();
			}
		}
  }
}
