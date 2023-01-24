package com.jvcodebr.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TicTacToe game = new TicTacToe();

        while (!game.breakGame) {

            System.out.println();
            game.ShowGameTable();
            System.out.println("Vez do jogador " + game.currentPlayer);
            System.out.println("Insira o numero da linha:");
            int row = input.nextInt();
    
            System.out.println("Insira o numero da coluna:");
            int column = input.nextInt();

            if (row >= 1 && row <= 3 && column >= 1 && column <= 3 ) {
                if (game.MakeMove(row, column)) {
                    game.currentMove++;
                    game.CheckResult(game.currentPlayer);
                    game.ToggleCurrentPlayer();
                } else {
                    System.out.println("Jogada inválida, tente novamente.");
                }
            } else {
                System.out.println("Coordenadas inválidas!");
            }

        }

    }
}
