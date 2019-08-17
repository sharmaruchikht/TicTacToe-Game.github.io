package tictactoe;

public class TicTacToe {

	public static void main(String[] args){
		GameBoard myGame = new GameBoard();
		myGame.displayBoard();
		int counter = 1;
		
		while (myGame.gameActive())
		{
			if (counter % 2 == 0)
				myGame.askPlayer('O');
			else 
				myGame.askPlayer('X');
			counter++;
		
		System.out.println("\n");
		myGame.displayBoard();
		myGame.checkForWinner();
                }
	}
}
