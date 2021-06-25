package com.bridgelabz.tictactoe;



public class TicTacToeGame {
	public static void main(String[] args) {
		createBoard();
	}

	private static void createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = '-';
		}
	}
}
