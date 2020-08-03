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
	static Random random = new Random();
	static boolean toss;
	static boolean choiceLetter;
	static Scanner in = new Scanner(System.in);
	static String playerInput;
	static String computerInput;
	
	public static void main(String[] args) {
		toss=random.nextBoolean();
		
		if(toss == true) {
			System.out.println("Player turn");
			
			System.out.println("Choose Letter X OR O");
			playerInput=in.next();
			
			if( playerInput.equals("X") || playerInput.equals("O")) 
				System.out.println("Player's choice "+playerInput);
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
			
			System.out.println("Computer is choice "+computerInput);
		}
	}

}
