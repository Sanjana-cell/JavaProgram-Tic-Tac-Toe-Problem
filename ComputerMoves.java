import java.util.Random;

/**
 * @author Sanjana K R
 * Date: 4-8-2020
 * Compilation Command: javac GameSimulator.java
 * Execution Command: java GameSimulator
 */

public class ComputerMoves {
	static Random random=new Random();
	
	
/*
 * Function checks for winning position
 */
static int checkPosition(String board[], String userInput) {
		String a="X";
		String b="O";
		int position=0;
		String result = null;
		int input = 0;
		for (int i = 0; i < 23; i++) {
			
			switch (i) {
			case 0:
				result = board[0] + board[1];
				position=3;
				break;
			case 1:
				result = board[3] + board[4];
				position=6;
				break;
			case 2:
				result = board[6] + board[7];
				position=9;
				break;
			case 3:
				result = board[1] + board[2];
				position=1;
				break;
			case 4:
				result = board[4] + board[5];
				position=4;
				break;
			case 5:
				result = board[7] + board[8];
				position=7;
				break;
			case 6:
				result = board[0] + board[3];
				position=7;
				break;
			case 7:
				result = board[1] + board[4];
				position=8;
				break;
			case 8:
				result = board[2] + board[5];
				position=9;
				break;
			case 9: 
				result = board[3] + board[6];
				position=1;
				break;
			case 10:
				result = board[4] + board[7];
				position=2;
				break;
			case 11: 
				result = board[5] + board[8];
				position=3;
				break;
			case 12:
				result = board[0] + board[4];
				position=9;
				break;
			case 13:
				result = board[4] + board[8];
				position=1;
				break;
			case 14:
				result = board[2] + board[4];
				position=7;
				break;
			case 15:
				result = board[4] + board[6];
				position=3;
				break;
			case 16:
				result = board[0] + board[8];
				position=5;
				break;
			case 17:
				result = board[6] + board[2];
				position=5;
				break;
			case 18:
				result = board[0] + board[2];
				position=2;
				break;
			case 19:
				result = board[3] + board[5];
				position=5;
				break;
			case 20:
				result = board[6] + board[8];
				position=8;
				break;
			case 21:
				result = board[0] + board[6];
				position=4;
				break;
			case 22:
				result = board[1] + board[7];
				position=5;
				break;
			case 23:
				result = board[2] + board[8];
				position=6;
				break;
			}
			if (result.equals("XX") && a.equals(userInput) && board[position-1].equals(String.valueOf(position))) 
					return position;
			else if (result.equals("OO") && b.equals(userInput) && board[position-1].equals(String.valueOf(position))) 
					return position;
		}
		return input;

}
}
