package com.kodilla;

import java.util.Scanner;

public class ConsoleController {
    private final static Scanner scanner = new Scanner(System.in);

    public static void showInputRowandColumnMessage(char symbol) {
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
        System.out.println("Wrong symbol, pleace use from 0 to 2!");
    }
}
