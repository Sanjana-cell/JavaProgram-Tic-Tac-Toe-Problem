import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Sanjana K R Date: 2-8-2020 Compilation Command: javac
 *         GameSimulator.java Execution Command: java GameSimulator
 */
public class GameSimulator {

	static String[] board = new String[9];
	private static Scanner in;
	static String playerInput;
	static String computerInput;
	static boolean toss;
	static boolean choiceLetter;
	static Random random = new Random();
	static int input;
	static String turn = null;
	static String win = null;
	static int computerWinPosition;
	static int playerWinPosition = 0;

	public static void main(String[] args) {
		GameSimulator game = new GameSimulator();
		in = new Scanner(System.in);
		String result=null;
		game.createEmptyBoard(); // function call to reset the board
		chooseLetter();
		turn = game.chooseTurn();

		
		System.out.println("Welcome to Tic Tac Toe Game");
		System.out.println("--------------------------------");

		game.displayBoard(); // function call to display board
		result=game.playGame(game); //function call to play game
		
		if (result.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw!");
		} else {
			String winner = (result.equals(playerInput)) ? "Player" : "Computer";
			System.out.println("Congratulations! " + winner + " has won! ");
		}
	}
   
	/*
	 * Function to play tic tac toe game.
	 */
	String playGame(GameSimulator game) {
		// loops till win is null
		while (win == null) {
			if (turn.equals(playerInput)) {
				System.out.println("Enter a slot number to place " + playerInput + " in:");
				input = in.nextInt();
				if (!(input > 0 && input <= 9)) {
					System.out.println("Invalid input; enter slot number:");
					continue;
				}
			} else {
				System.out.println("Computer's turn");
				computerWinPosition = ComputerMoves.checkPosition(board, computerInput);
				playerWinPosition = ComputerMoves.checkPosition(board, playerInput);
				input=computerPosition(computerWinPosition, playerWinPosition);
				System.out.println("Computer's input " + input);
			}
			if (board[input - 1].equals(String.valueOf(input))) {
				board[input - 1] = turn;
				game.displayBoard(); // function call to display board
				win = game.winnerCheck(); // function call to check the winner
				if (turn.equals(playerInput)) {
					turn = computerInput;
				} else {
					turn = playerInput;
				}

			} else {
				System.out.println("Slot already taken; enter slot number:");
				if (turn.equals(computerInput))
					input = random.nextInt(10 - 1) + 1;
			}
		}
		return win;
	}
	static int computerPosition(int computerPosition, int playerPosition) {
		if (computerWinPosition == 0 && playerWinPosition == 0) {
			input = checkOtherPosition();
			System.out.println(input);
		}

		else if (computerWinPosition != 0) {
			input = computerWinPosition;
		}

		else if (playerWinPosition != 0) {
			input = playerWinPosition;
		}
		return input;
		
	}

	/*
	 * Function to choose the letter
	 */
	static void chooseLetter() {
		String choice;
		System.out.println("Select X or O");
		while (true) {
			choice = in.next();

			if (choice.equals("X") || choice.equals("O") || choice.equals("x") || choice.equals("o")) {
				if(choice.equals("x"))
					playerInput="X";
				else if(choice.equals("o"))
					playerInput="O";
				else
					playerInput=choice;
				System.out.println("Player's choice " + playerInput);

				choiceLetter = random.nextBoolean();
				if (choiceLetter == true && playerInput.equals("O"))
					computerInput = "X";
				else
					computerInput = "O";
				break;
			}

			else
				System.out.println("Invalid Choice !! choose X OR O");
			continue;
		}
	}

	/*
	 * Function Displays the tic tac toe board
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
			board[i] = String.valueOf(i + 1);
		}
	}

	/*
	 * Function to choose who plays first
	 */
	String chooseTurn() {
		boolean toss = random.nextBoolean();
		if (toss == true) {
			System.out.println("Player turn");
			return playerInput;
		} else
			System.out.println("Computer turn");
		System.out.println(computerInput);
		return computerInput;
	}

	/*
	 * Function to get corner position or center position
	 */
	static int checkOtherPosition() {
		if (board[0].equals(String.valueOf(1)))
			return 1;
		else if (board[2].equals(String.valueOf(3)))
			return 3;
		else if (board[6].equals(String.valueOf(7)))
			return 7;
		else if (board[8].equals(String.valueOf(9)))
			return 9;
		else if (board[4].equals(String.valueOf(5)))
			return 5;
		else if (board[3].equals(String.valueOf(4)))
			return 4;
		else if (board[5].equals(String.valueOf(6)))
			return 6;
		else
			return random.nextInt(10 - 1) + 1;

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
		for (int i = 0; i < 9; i++) {
			if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
				break;
			} else if (i == 8)
				return "draw";
		}
		return null;
	}
}
