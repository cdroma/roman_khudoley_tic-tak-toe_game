package com.kodilla;

import java.util.Scanner;
public class Game {

    private final Board board= new Board();

    private final Player player1 = new Player('X');

    private final Player player2 = new Player('0');

    private Player currentPlayer;



    public Game() {
        currentPlayer = player1;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (!board.isBoardFull() && !board.isWinner(currentPlayer.getSymbol())) {
            board.displayBoard();
            ConsoleController.showInputRowAndColumnMessage(currentPlayer.getSymbol());
            try {

                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (board.isValidMove(row, col)) {
                    board.placeMove(row, col, currentPlayer.getSymbol());

                    if (board.isWinner(currentPlayer.getSymbol())) {
                        ConsoleController.displayWinner(currentPlayer.getSymbol());


                        break;
                    }

                    if (board.isBoardFull()) {
                        ConsoleController.displayTie();


                        break;
                    }

                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                } else {
                    ConsoleController.warningofIllegalMove();

                }
            } catch (Exception exception) {
                ConsoleController.warningOfException();

                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
