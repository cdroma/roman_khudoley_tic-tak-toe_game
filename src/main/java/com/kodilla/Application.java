package com.kodilla;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsoleController.welcomeToGame();

        boolean isValidChoice = false;
        while (!isValidChoice) {
            ConsoleController.choosingBoardSize();
            ConsoleController.boardSize3x3();
            ConsoleController.boardSize10x10();

            int choice = scanner.nextInt();

            if (choice == 1) {
                Game game = new Game(3);
                game.startGame();
                isValidChoice = true;
            } else if (choice == 2) {
                Game game = new Game(10);
                game.startGame();
                isValidChoice = true;
            } else {
                ConsoleController.invalidChoise();
            }
        }

        scanner.close();


    }
}
