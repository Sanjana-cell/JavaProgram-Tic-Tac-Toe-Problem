import java.util.Random;

/**
 * @author Sanjana K R
 * Date: 8-2-2020
 * Compilation Command: javac GameSimulator.java
 * Execution Command: java GameSimulator
 */
public class GameSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] board = new int[3][3];
		Random random = new Random();
		boolean toss=random.nextBoolean();
		if(toss == true)
			System.out.println("Player turn");
		else
			System.out.println("Computer turn");
	}

}
