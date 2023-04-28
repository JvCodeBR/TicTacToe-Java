package br.com.jvcodebr.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner SCAN = new Scanner(System.in);
        Board board = new Board();
        while (true) {
            board.startGame();
            System.out.print("Play again? (y/n) ");
            String option = SCAN.nextLine();
            if (option.equalsIgnoreCase("y")) {
                board.cleanBoard();
            } else {
                break;
            }
        }

    }
}
