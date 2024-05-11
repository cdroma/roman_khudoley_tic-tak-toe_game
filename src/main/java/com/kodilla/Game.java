package com.kodilla;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Board board = new Board();
    private final Player player1 = new Player('X');
    private final Player player2 = new Player('O');
    private Player currentPlayer;

    public Game() {
        currentPlayer = player1;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (!board.isBoardFull() && !board.isWinner(player1.getSymbol()) && !board.isWinner(player2.getSymbol())) {
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
                // computer makes a move:
                int row, col;
                do {
                    row = random.nextInt(3);
                    col = random.nextInt(3);
                } while (!board.isValidMove(row, col));
                board.placeMove(row, col, currentPlayer.getSymbol());
            }

            if (board.isWinner(currentPlayer.getSymbol())) {
                ConsoleController.displayWinner(currentPlayer.getSymbol());
                break;
            }

            if (board.isBoardFull()) {
                ConsoleController.displayTie();
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }
}
