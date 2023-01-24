package com.jvcodebr.tictactoe;

public class TicTacToe {
    
    char[][] gameTable = new char[3][3];
    char playerOne = 88;
    char playerTwo = 48;
    int currentMove = 1;
    char currentPlayer = playerOne;
    boolean breakGame = false;

    void ShowGameTable() {
        for (int i=0; i<gameTable.length;i++) {
            for (int j=0; j<gameTable[i].length;j++) {
                System.out.print(gameTable[i][j] + " |");
            }
            System.out.println();
        }
    }

    void ToggleCurrentPlayer() {
        if (currentMove % 2 != 0 ) {
            currentPlayer = playerOne;
        } else {
            currentPlayer = playerTwo;
        }
    }

    boolean MakeMove(int row, int column) {
        if (gameTable[row-1][column-1] != playerOne && gameTable[row-1][column-1] != playerTwo) {
            gameTable[row-1][column-1] = currentPlayer;
            return true;
        }
        return false;
    }

    void CheckResult(char player) {
        if (gameTable[0][0] == player && gameTable[0][1] == player && gameTable[0][2] == player ||
            gameTable[1][0] == player && gameTable[1][1] == player && gameTable[1][2] == player ||
            gameTable[2][0] == player && gameTable[2][1] == player && gameTable[2][2] == player ||
            
            gameTable[0][0] == player && gameTable[1][0] == player && gameTable[2][0] == player ||
            gameTable[0][1] == player && gameTable[1][1] == player && gameTable[2][1] == player ||
            gameTable[0][2] == player && gameTable[1][2] == player && gameTable[2][2] == player ||
            
            gameTable[0][0] == player && gameTable[1][1] == player && gameTable[2][2] == player ||
            gameTable[0][2] == player && gameTable[1][1] == player && gameTable[2][0] == player) {
                System.out.println("Jogador " + currentPlayer + " Vencedor!");
                breakGame = true;
            } else if (currentMove > 9) {
                System.out.println("Deu velha! Jogo empatou.");
                breakGame = true;
            }
    }
    
}
