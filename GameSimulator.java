import java.util.Random;
import java.util.Scanner;

/**
 * @author Sanjana K R
 * Date: 8-2-2020
 * Compilation Command: javac GameSimulator.java
 * Execution Command: java GameSimulator
 */
public class GameSimulator {
	
	String[][] board = new String[3][3];
	private static Scanner in;
	
	/*
	  Function Displays the tic tac toe board
	 */
	public void displayBoard() {
		System.out.println("Tic Tac Toe Board");
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println(" ");
		}
		
	}
	
	public static void main(String[] args) {
		GameSimulator game = new GameSimulator();
		Random random = new Random();
		boolean toss;
		boolean choiceLetter;
		in = new Scanner(System.in);
		String playerInput;
		String computerInput;
		
		toss=random.nextBoolean();
		
		if(toss == true) {
			System.out.println("Player turn");
			
			System.out.println("Choose Letter X OR O");
			playerInput=in.next();
			
			if( playerInput.equals("X") || playerInput.equals("O")) { 
				System.out.println("Player's choice "+playerInput);
				game.displayBoard();
			}
			else
				System.out.println("Invalid input choose X or O");
		}
		else {
			choiceLetter=random.nextBoolean();
			System.out.println("Computer turn");
			
			if(choiceLetter == true) 
				computerInput="X";
			else
				computerInput="O";
			
			System.out.println("Computer's choice "+computerInput);
		}
	}

}
