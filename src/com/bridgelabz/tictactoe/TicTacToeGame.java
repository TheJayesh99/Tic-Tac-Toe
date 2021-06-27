package com.bridgelabz.tictactoe;


import java.util.Scanner;

public class TicTacToeGame
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);		
		char[] board = createBoard();
		System.out.println("Enter The Symbol which you want i.e. X or O");
		char playerSymbol = scanner.next().toUpperCase().charAt(0);
		char computerSymbol = determineComputerSymbol(playerSymbol);
		displayBoard(board);
		boolean playerTurn = toss();
		
		System.out.println(board[1]);
		while(true)
		{	
			char winner = win(board);
			if(winner == 'X' | winner == 'O')
			{
				if(playerSymbol == winner)
				{					
					System.out.println("Player Won");
				}
				else
				{
					System.out.println("Computer Won");
				}
				break;
			}
			else if(checkFreeSpace(board))
			{	
				if(playerTurn) 
				{	
					System.out.println("Your turn");
					playerMove(scanner, board, playerSymbol);
					playerTurn = !(playerTurn);
				}
				else
				{
					System.out.println("computer Turn");
					computerMove(board, computerSymbol);
					displayBoard(board);				
					playerTurn = !(playerTurn);
				}
			}
			else
			{
				System.out.println("The game Tie");
				break;

			}
		}
		scanner.close();
	}

	private static int computerMove(char[] board, char computerSymbol) {
		int compMark = 0 ;
		//					Row 1
		if (board[1] == board[2]  && board[1] != '-' && board[3] == '-' )
		{
			board[3] = computerSymbol;
		}
		else if (board[1] == board[3] && board[1] != '-' && board[2] == '-')
		{
			board[2] = computerSymbol;
		}
		else if (board[2] == board[3] && board[2] != '-' && board[1] == '-')
		{
			board[1] = computerSymbol;
		}
		
		//Row 2 
		else if (board[4] == board[5] && board[4] != '-' && board[6] == '-' )
		{
			board[6] = computerSymbol;
		}
		else if (board[4] == board[6] && board[4] != '-' && board[5] == '-' )
		{
			board[5] = computerSymbol;
		}
		else if (board[6] == board[5] && board[5] != '-' && board[4] == '-' )
		{
			board[4] = computerSymbol;
		}
		
		//Row 3
		else if ((board[7] == board[8] && board[7] != '-' && board[9] == '-'))
		{
			board[9] = computerSymbol;
		}
		else if ((board[7] == board[9] && board[7] != '-' && board[8] == '-'))
		{
			board[8] = computerSymbol;
		}
		else if ((board[8] == board[9] && board[8] != '-' && board[7] == '-'))
		{
			board[7] = computerSymbol;
		}
		
		//Col 1
		else if ((board[1] == board[4] && board[1] != '-' && board[7] == '-'))
		{
			board[7] = computerSymbol;
		}
		else if ((board[1] == board[7] && board[1] != '-' && board[4] == '-'))
		{
			board[4] = computerSymbol;
		}
		else if ((board[7] == board[4] && board[7] != '-' && board[1] == '-'))
		{
			board[1] = computerSymbol;
		}
		
		//Col 2
		else if ((board[2] == board[5] && board[2] != '-' && board[8] == '-'))
		{
			board[8] = computerSymbol;
		}
		else if ((board[2] == board[8] && board[2] != '-' && board[5] == '-'))
		{
			board[5] = computerSymbol;
		}
		else if ((board[5] == board[8] && board[5] != '-' && board[2] == '-'))
		{
			board[2] = computerSymbol;
		}
		
		//Col3
		else if ((board[3] == board[6] && board[3] != '-' && board[9] == '-'))
		{
			board[9] = computerSymbol;
		}
		else if ((board[3] == board[9] && board[3] != '-' && board[6] == '-' ))
		{
			board[6] = computerSymbol;
		}
		else if ((board[6] == board[9] && board[6] != '-' && board[3] == '-'))
		{
			board[3] = computerSymbol;
		}

		//Diagonal left 2 right
		else if ((board[1] == board[5] && board[1] != '-' && board[9] == '-' ))
		{
			board[9] = computerSymbol;
		}
		else if ((board[1] == board[9] && board[1] != '-' && board[5] == '-' ))
		{
			board[5] = computerSymbol;
		}
		else if ((board[5] == board[9] && board[5] != '-' && board[1] == '-'))
		{
			board[1] = computerSymbol;
		}

		//Diagonal right 2 left
		else if ((board[3] == board[5] && board[3] != '-' && board[7] == '-'))
		{
			board[7] = computerSymbol;
		}
		else if ((board[7] == board[5] && board[7] != '-' && board[3] == '-'))
		{
			board[3] = computerSymbol;
		}
		else if ((board[7] == board[3] && board[7] != '-' && board[5] == '-'))
		{
			board[5] = computerSymbol;
		}
		
		else
		{
			while (true)
			{
				compMark =(int) Math.floor(Math.random() * 10);
				if(board[compMark] == '-' && compMark != 0)
				{
					board[compMark] = computerSymbol;
					break;
				}
			}
		}
		return compMark;
	}

	private static char win(char[] board) {
		char win = '-';
		// Condition horizontal			
		if( (board[1] == board[2] && board[1] == board[3]) && (board[1] != '-' ) )
		{
			win = board[1];
		}
		else if ((board[4] == board[5] && board[4] == board[6]) && (board[4] != '-' )) 
		{
			win = board[4];
		}
		else if ((board[7] == board[8] && board[8] == board[9]) && (board[7] != '-' )) 
		{
			win = board[7];
		}
		// Condition Vertical
		else if ((board[1] == board[4] && board[4] == board[7]) && (board[1] != '-' )) 
		{
			win = board[1];
		}
		else if ((board[2] == board[5] && board[5] == board[8]) && (board[2] != '-' )) 
		{
			win = board[2];
		}
		else if ((board[3] == board[6] && board[6] == board[9]) && (board[3] != '-' )) 
		{
			win = board[3];
		}
		//Diagonal Conditions
		else if ((board[1] == board[5] && board[5] == board[9]) && (board[1] != '-' )) 
		{
			win = board[1];
		}
		else if ((board[3] == board[5] && board[5] == board[7]) && (board[3] != '-' )) 
		{
			win = board[3];
		}
		return win;
	}

	private static boolean toss() {
		int toss = (int)Math.floor(Math.random() *10) % 2 ;
		int playerOwnToss = 1;
		boolean playerTurn;
		if (toss == playerOwnToss ) 
		{
			playerTurn = true;
			System.out.println("You own the toss  ");
		} 
		else 
		{
			playerTurn = false;
			System.out.println("computer own the toss ");
		}
		return playerTurn;
	}

	private static boolean checkFreeSpace(char[] board) {
		boolean isFreeSpace = true;
		int numberOfFreeSpace = 0;
		for (int index = 1; index < board.length; index++)
		{
			if(board[index]== '-')
			{
				numberOfFreeSpace++;
			}
		}
		if(numberOfFreeSpace == 0)
		{
			isFreeSpace=false;
		}
		return isFreeSpace;
	}

	private static void playerMove(Scanner scanner, char[] board, char playerSymbol) 
	{
		boolean playerTurn = true;
		while(playerTurn) 
		{
			System.out.println("Enter the Symbol where you want to place your "+playerSymbol);
			int playerMove = scanner.nextInt();
			if(board[playerMove] == '-')
			{
				board[playerMove] = playerSymbol;
				playerTurn = false;
			}
			else
			{
				System.out.println("The mark location is not free");
			}
		}
		displayBoard(board);
	}

	private static void displayBoard(char[] board)
	{
		for (int index = 1; index < board.length; index++) 
		{
			System.out.print(board[index]);
			if(index%3 == 0)
			{
				System.out.println();
			}
			else 
			{
				System.out.print(" | ");
			}
		}
	}

	private static char determineComputerSymbol(char playerSymbol) {
		char computerSymbol = '-' ;
		if (playerSymbol == 'X')
		{
			computerSymbol = 'O';
		}
		else if (playerSymbol == 'O')
		{
			computerSymbol = 'X';
		}
		else
		{
			System.err.println("You inserted a wrong Symbol");

		}
		return computerSymbol;
	}

	private static char[] createBoard()
	{
		char[] board = new char[10];
		for (int index = 1; index < board.length; index++) 
		{
			board[index] = '-';
		}
		return board;
	}


}
