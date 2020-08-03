import java.util.Random;
import java.util.Scanner;

/**
 * @author Sanjana K R
 * Date: 8-2-2020
 * Compilation Command: javac GameSimulator.java
 * Execution Command: java GameSimulator
 */
public class GameSimulator {
	
	String[] board = new String[9];
	private static Scanner in;
	
	/*
	  Function Displays the tic tac toe board
	 */
	
	void displayBoard() {
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
	}
	
	/*
	 * Function to create to reset board 
	 */
	void createEmptyBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = String.valueOf(i+1);
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
		
		game.createEmptyBoard(); //function call to reset the board
		
		toss=random.nextBoolean(); 
		
		if(toss == true) {
			System.out.println("Player turn");
			
			System.out.println("Choose Letter X OR O");
			playerInput=in.next();
			
			if( playerInput.equals("X") || playerInput.equals("O")) { 
				System.out.println("Player's choice "+playerInput);
				game.displayBoard(); //function call to display the board
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
