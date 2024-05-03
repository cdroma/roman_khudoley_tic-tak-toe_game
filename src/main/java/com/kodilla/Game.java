package com.kodilla;

import java.util.Scanner;
public class Game {

    private Board board;

    private Player player1;

    private Player player2;

    private Player currentPlayer;

    public Game() {

        board = new Board();
        player1 = new Player('X');
        player2 = new Player('0');
        currentPlayer = player1;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (!board.isBoardFull() && !board.isWinner(currentPlayer.getSymbol())) {
            board.displayBoard();
            System.out.println("Player" + " " + currentPlayer.getSymbol() + " " + "enter row and column (divided by space):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.isValidMove(row, col)) {
                board.placeMove(row, col, currentPlayer.getSymbol());

                if (board.isWinner(currentPlayer.getSymbol())) {
                    System.out.println("Player" + " " + currentPlayer.getSymbol() + " " + "wins!");

                    break;

                }

                if (board.isBoardFull()) {
                    System.out.println("It's a tie!");

                    break;

                }
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Wrong move, please try again!");
            }
        }

        scanner.close();
    }
}
