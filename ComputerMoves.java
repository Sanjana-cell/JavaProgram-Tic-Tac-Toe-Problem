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
 * Generates the winning position or blocking position
 */
static int generatesPosition(String board[],String userInput, int index1, int index2, int index3) {
	if(board[index1].equals(String.valueOf(index1+1)) && board[index2].equals(userInput) && board[index3].equals(userInput) )
		return index1+1;
	else if(board[index1].equals(userInput) && board[index2].equals(userInput) && board[index3].equals(String.valueOf(index3+1)))
		return index3+1;
	else if(board[index1].equals(userInput) && board[index2].equals(String.valueOf(index2+1)) && board[index3].equals(userInput))
		return index2+1;
	else
		return 0;
}

/*
 * Function checks for winning position
 */
static int checkPosition(String board[], String userInput) {
		int position=0;
		int input = 0;
		for (int i = 0; i < 8; i++) {
			
			switch (i) {
			case 0:
				position = generatesPosition(board, userInput, 0, 1,2); //row wise winning or blocking position
				break;
			case 1:
				position = generatesPosition(board, userInput, 3, 4,5); //row wise winning or blocking position
				break;
			case 2:
				position = generatesPosition(board, userInput, 6, 7, 8); //row wise winning or blocking position
				break;
			case 3:
				position = generatesPosition(board, userInput, 0, 3, 6); //Column wise winning or blocking position
				break;
			case 4:
				position = generatesPosition(board, userInput, 1, 4, 7); //Column wise winning or blocking position
				break;
			case 5:
				position = generatesPosition(board, userInput, 2, 5, 8); //Column wise winning or blocking position
				break;
			case 6:
				position = generatesPosition(board, userInput, 0, 4, 8); //diagonal wise winning or blocking position
				break;
			case 7:
				position = generatesPosition(board, userInput, 2, 4, 6); //diagonal wise winning or blocking position
				break;
			}
			 if (position != 0)
				 return position;
			
		}	
		return input;
	}
}
