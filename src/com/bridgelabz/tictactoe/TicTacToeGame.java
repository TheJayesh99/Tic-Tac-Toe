package com.bridgelabz.tictactoe;



public class TicTacToeGame {
	public static void main(String[] args) {
		
		char[] board = new char[10];
		
		createBoard(board);
		
	}

	private static void createBoard(char[] board) {
		for (int i = 1; i < board.length; i++) {
			board[i] = '-';
		
		}
	}
}
