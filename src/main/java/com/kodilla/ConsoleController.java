package com.kodilla;

import java.util.Scanner;

public class ConsoleController {
    private final static Scanner scanner = new Scanner(System.in);

    public  static  void welcomeToGame(){System.out.println("Welcome to Tic Tac Toe game!");}

    public static void choosingBoardSize(){System.out.println("Choose board size:");}

    public static void boardSize3x3(){System.out.println("1. Classic mode (3x3)");}

    public static void boardSize10x10(){System.out.println("2. Alternative mode (10x10)");}

    public static void invalidChoise(){System.out.println("Invalid choice. Please choose 1 or 2.");}

    public static void showInputRowAndColumnMessage(char symbol) {
        System.out.println("Player" + " " + symbol + " " + "enter row and column (divided by space):");
    }

    public static void displayWinner(char symbol) {
        System.out.println("Player" + " " + symbol + " " + "wins!");
    }
    public  static  void displayTie() {
        System.out.println("It's a tie!");
    }

    public static  void warningofIllegalMove() {
        System.out.println("Wrong move, please try again!");
    }

    public static void warningOfException() {
        System.out.println("Wrong symbol, please use from 0 to 2!");
    }
}
