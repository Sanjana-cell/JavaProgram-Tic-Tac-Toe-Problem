import java.util.Random;
import java.util.Scanner;

/**
 * @author Sanjana K R
 * Date: 8-2-2020
 * Compilation Command: javac GameSimulator.java
 * Execution Command: java GameSimulator
 */
public class GameSimulator {
	
	static String[] board = new String[9];
	private static Scanner in;
	static String playerInput;
	static String computerInput;
	static boolean toss;
	static boolean choiceLetter;
	static Random random = new Random();
	
	public static void main(String[] args) {
		GameSimulator game = new GameSimulator();
		in = new Scanner(System.in);
		
		game.createEmptyBoard(); //function call to reset the board
		chooseLetter();
		String win = null;
		
		System.out.println("Welcome to Tic Tac Toe Game");
		System.out.println("--------------------------------");
		game.displayBoard(); //function call to display board
		System.out.println("Enter a slot number to place"+ playerInput+ "in:");
		
		//loops till win is null 
		while (win == null) {
			int input;
			input = in.nextInt();
			if (!(input > 0 && input <= 9)) {
				System.out.println("Invalid input; enter slot number:");
				continue;
			}
			if (board[input-1].equals(String.valueOf(input))) {
				board[input-1] = playerInput;
				game.displayBoard(); // function call to display board
				win = game.winnerCheck(); // function call to check the winner
			} else {
				System.out.println("Slot already taken; enter slot number:");
				continue;
			}
		}
		System.out.println("Congratulations! You have won!");		
	}
	
	/*
	 * Function to choose the letter
	 */
	static void chooseLetter() {
		System.out.println("Select X or O");
		while(true) {
		playerInput=in.next();
		
		if( playerInput.equals("X") || playerInput.equals("O")) {
			System.out.println("Player's choice "+playerInput);
			
			choiceLetter=random.nextBoolean();
			if(choiceLetter == true && playerInput.equals("O")) 
				computerInput="X";
			else
				computerInput="O";
				break;
		}
		
		else
			System.out.println("Invalid Choice !! choose X OR O");
			continue;
		}
	}
	
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
	
	/*
	 * Function to Check the winner
	 */
	
	String winnerCheck() {
		
		for (int i = 0; i < 8; i++) {
			String result = null;
			switch (i) {
			case 0:
				result = board[0] + board[1] + board[2];
				break;
			case 1:
				result = board[3] + board[4] + board[5];
				break;
			case 2:
				result = board[6] + board[7] + board[8];
				break;
			case 3:
				result = board[0] + board[3] + board[6];
				break;
			case 4:
				result = board[1] + board[4] + board[7];
				break;
			case 5:
				result = board[2] + board[5] + board[8];
				break;
			case 6:
				result = board[0] + board[4] + board[8];
				break;
			case 7:
				result = board[2] + board[4] + board[6];
				break;
			}
			if (result.equals("XXX")) {
				return "X";
			} else if (result.equals("OOO")) {
				return "O";
			} 
		}
		System.out.println("enter a slot number to place ");
		return null;
	}
}
