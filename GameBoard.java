package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
       private char[][] gameBoard;
       private boolean gameOnGoing = true;
       /**
        * This is the constructor for the GameBoard class
        */
       public GameBoard()
       {
    	   gameBoard = new char[3][3];
    	   for (int row=0; row < gameBoard.length; row++)
    	   {
    		   Arrays.fill(gameBoard[row], ' ');
    	   }
       } //end of constructor
       
       /**
        * This method will display the gameBoard to the screen
        */
       
       public void displayBoard()
       {
    	   for(int row=0; row < gameBoard.length; row++){
    		   for(int col=0; col < gameBoard[0].length; col++){
    			   System.out.print("\t"+gameBoard[row][col]);
    			   if(col == 0 || col == 1)
    				   System.out.print("|");
    		   }
    		   if(row ==0 || row == 1)
    		   System.out.print("\n---------------------------\n");
    	   }
    	   System.out.println();
       } //end of method displayboard 
       /**
        * This method will return type if the game is still active.
     * @return 
        */
       public boolean gameActive()
       {
    	   return gameOnGoing;
       }
       /**
        * This method will ask the user to pick a row and column, validate the inputs
        * and call the method makeMove()
        */
       public void askPlayer(char player)
       {
    	   Scanner keyboard = new  Scanner(System.in);
    	   int row, col;
    	   do{
    		   System.out.printf("Player %s please enter a row (1-3): ", player);
    		   row = keyboard.nextInt();
    		   
    		   System.out.printf("Player %s please enter a column (1-3): ", player);
    		   col = keyboard.nextInt();
    		   
    		   
    	   }  while (notValid(row,col));
    	   
    	   makeMove(player,row-1,col-1);
    	   
       } //end of the askPlayer method
       
        /**
        * This method will validate if the row and column are between 1-3
        * and if the position is currently empty
     */
       public boolean notValid(int row, int col)
       {
    	   if(row > 3 || row < 1 || col > 3 || col < 1 || !isEmpty(row, col))
    		   return true;
    	   else
    	   return false;
       }
       

       /**
        * This method will check to see if there are 3 X's or O's in a row
        * @return true if there is a winner, false otherwise
        */
       
       public boolean checkForWinner()
       {
    	   //loop over each row and check for a winner
    	   for ( int row = 0; row < gameBoard.length; row++)
    	   {
    		   if(gameBoard[row][0]==gameBoard[row][1] && gameBoard[row][1]==gameBoard[row][2] 
    				   && gameBoard[row][0] != ' ')
    		   {
    		System.out.print("The winner is "+ gameBoard[row][0]);
    		   gameOnGoing = false;
    		   }
    	   }
    	   
    	   //loop over each column and check for a winner
    	   for ( int col = 0; col < gameBoard.length; col++)
    	   {
    		   if(gameBoard[0][col]==gameBoard[1][col] && gameBoard[1][col]==gameBoard[2][col] 
    				   && gameBoard[0][col] != ' ')
    		   {
    	    		System.out.print("The winner is "+ gameBoard[0][col]);
    	    		   gameOnGoing = false;
    	    		   }
    	   }
    	   
    	   
    	   //check the crosses
    	   if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[2][2] 
				   && gameBoard[0][0] != ' ')
    	   {
       		System.out.print("The winner is "+ gameBoard[0][0]);
       		   gameOnGoing = false;
       		   }
    	   
    	   if(gameBoard[2][0]==gameBoard[1][1] && gameBoard[1][1]==gameBoard[0][2] 
				   && gameBoard[0][2] != ' ')
    	   {
       		System.out.print("The winner is "+ gameBoard[1][1]);
       		   gameOnGoing = false;
       		   }
       return false;
       }
       
       
             /**
        * This method will check if a position is empty
        * @return true if the position is empty, false otherwise
        */
       
       public boolean isEmpty (int row, int col)
       {
    	   if(gameBoard[row-1][col-1] == ' ')
    		   return true ;
    	   else
    		   return false;
       }
          
       
       /**
        * This method will validate if a player move is allowed and return true
        * if the move was completed
     * @return 
        */
       public boolean makeMove(char player, int row, int col)
       {
    	   if (row >=0 && row <=2 && col >=0 && col <=2)
    	   {
    		   if (gameBoard[row][col] != ' ')
    			   return false;
    		   else
    		   {
    			   gameBoard[row][col] = player;
    			   return true;
    		   }
    	   }
    	   else
		        return false;
       }
}

