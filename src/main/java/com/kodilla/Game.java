package com.kodilla;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final int SIZE;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    private final GameHistory gameHistory;
    private int gamesPlayed;


    public Game(int size) {
        SIZE = size;
        board = new Board(SIZE);
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        gameHistory = new GameHistory();
        gamesPlayed = 0;

    }


    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (!board.isBoardFull() && !isWinner(player1.getSymbol()) && !isWinner(player2.getSymbol())) {
            board.displayBoard();

            if (currentPlayer == player1) {
                ConsoleController.showInputRowAndColumnMessage(currentPlayer.getSymbol());
                try {
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    if (board.isValidMove(row, col)) {
                        board.placeMove(row, col, currentPlayer.getSymbol());
                    } else {
                        ConsoleController.warningofIllegalMove();
                        continue;
                    }
                } catch (Exception exception) {
                    ConsoleController.warningOfException();
                    scanner.nextLine();
                    continue;
                }
            } else {
                // Computer makes a move:
                int row, col;
                do {
                    row = random.nextInt(SIZE);
                    col = random.nextInt(SIZE);
                } while (!board.isValidMove(row, col));
                board.placeMove(row, col, currentPlayer.getSymbol());
            }

            if (isWinner(currentPlayer.getSymbol())) {
                ConsoleController.displayWinner(currentPlayer.getSymbol());
                gamesPlayed++;
                gameHistory.addToHistory("Player " + currentPlayer.getSymbol(), gamesPlayed, 1);
                gamesPlayed++;

                break;
            }

            if (board.isBoardFull()) {
                ConsoleController.displayTie();
                gameHistory.addToHistory("Tie", gamesPlayed, 0);
                gamesPlayed++;

                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        gamesPlayed++;


        gameHistory.saveToFile("game_stats.txt");

        scanner.close();


    }

    private boolean isWinner(char symbol) {
        // checking horizontal:
        for (int i = 0; i < SIZE; i++) {
            int rowCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (board.getBoard()[i][j] == symbol) {
                    rowCounter++;
                    if (rowCounter == (SIZE == 3 ? 3 : 5)) return true;
                } else {
                    rowCounter = 0;
                }
            }
        }

        // checking vertical:
        for (int j = 0; j < SIZE; j++) {
            int colCounter = 0;
            for (int i = 0; i < SIZE; i++) {
                if (board.getBoard()[i][j] == symbol) {
                    colCounter++;
                    if (colCounter == (SIZE == 3 ? 3 : 5)) return true;
                } else {
                    colCounter = 0;
                }
            }
        }

        // checking main diagonal (top-left to bottom-right)
        for (int i = 0; i <= SIZE - (SIZE == 3 ? 3 : 5); i++) {
            for (int j = 0; j <= SIZE - (SIZE == 3 ? 3 : 5); j++) {
                boolean win = true;
                for (int k = 0; k < (SIZE == 3 ? 3 : 5); k++) {
                    if (board.getBoard()[i + k][j + k] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        // checking anti-diagonal (top-right to bottom-left)
        for (int i = 0; i <= SIZE - (SIZE == 3 ? 3 : 5); i++) {
            for (int j = (SIZE == 3 ? 2 : 4); j < SIZE; j++) {
                boolean win = true;
                for (int k = 0; k < (SIZE == 3 ? 3 : 5); k++) {
                    if (board.getBoard()[i + k][j - k] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        return false;
    }
}



