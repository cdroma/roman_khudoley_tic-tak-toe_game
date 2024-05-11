package com.kodilla;

public class Board {
    private final char[][] board;
    private final int SIZE;

    public Board(int size) {
        SIZE = size;
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("-------------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" | ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false;
        }
        return board[row][col] == ' ';
    }

    public void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public char[][] getBoard() {
        return board;
    }
}
