package br.com.jvcodebr.tictactoe;

import java.util.Scanner;

public class Board {
    private char[][] board;
    private Player playerOne;
    private Player playerTwo;
    private Integer currentMove;
    private Player currentPlayer;
    private Boolean isFinished;
    private final Scanner SCAN;

    Board() {
        this.board = new char[3][3];
        this.SCAN = new Scanner(System.in);
        this.isFinished = false;
    }

    public void startGame() {
        System.out.print("Player's one name: ");
        String namePlayerOne = SCAN.nextLine().trim();
        setPlayerOne(new Player(namePlayerOne, Simbol.CROSS));

        System.out.print("Player's two name: ");
        String namePlayerTwo = SCAN.nextLine().trim();
        setPlayerTwo(new Player(namePlayerTwo, Simbol.CIRCLE));

        this.setCurrentMove(1);
        this.setCurrentPlayer(playerOne);
        while (!getFinished()) {
            makeMove();
        }
    }

    public void cleanBoard() {
        setBoard(new char[3][3]);
        setFinished(false);
    }

    private void makeMove() {
        char simbolPlayerOne = playerOne.getSimbol().getSimbol();
        char simbolPlayerTwo = playerTwo.getSimbol().getSimbol();
        while (true) {
            System.out.println(getCurrentPlayer().getName() + "'s turn.");
            System.out.print("Row number: ");
            int row = requestNumber() - 1;
            System.out.print("Column number: ");
            int col = requestNumber() - 1;
            char cel = getBoard()[row][col];
            if (!(cel == simbolPlayerOne || cel == simbolPlayerTwo)) {
                getBoard()[row][col] = currentPlayer.getSimbol().getSimbol();
                setCurrentMove(getCurrentMove() + 1);
                showGameTable();
                checkResult(currentPlayer.getSimbol().getSimbol());
                toggleCurrentPlayer();
                break;
            } else {
                System.out.println("Cell not empty.");
            }
        }
    }

    private void showGameTable() {
        char[][] board = getBoard();
        for (int i=0; i<board.length;i++) {
            for (int j=0; j<board[i].length;j++) {
                System.out.print(board[i][j] + " |");
            }
            System.out.println();
        }
    }

    private void toggleCurrentPlayer() {
        setCurrentPlayer(getCurrentPlayer().equals(playerOne) ? getPlayerTwo() : getPlayerOne());
    }

    private void checkResult(char simbol) {
        char[][] board = getBoard();
        if (board[0][0] == simbol && board[0][1] == simbol && board[0][2] == simbol ||
                board[1][0] == simbol && board[1][1] == simbol && board[1][2] == simbol ||
                board[2][0] == simbol && board[2][1] == simbol && board[2][2] == simbol ||

                board[0][0] == simbol && board[1][0] == simbol && board[2][0] == simbol ||
                board[0][1] == simbol && board[1][1] == simbol && board[2][1] == simbol ||
                board[0][2] == simbol && board[1][2] == simbol && board[2][2] == simbol ||

                board[0][0] == simbol && board[1][1] == simbol && board[2][2] == simbol ||
                board[0][2] == simbol && board[1][1] == simbol && board[2][0] == simbol) {
            System.out.println("Player " + currentPlayer.getName() + " Winner!");
            this.setFinished(true);
        } else if (currentMove > 9) {
            System.out.println("Draw!");
            this.setFinished(true);
        }
    }

    private int requestNumber() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(SCAN.nextLine());
                if (number >= 1 && number <= 3) {
                    return number;
                } else {
                    System.out.println("Invalid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Integer getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(Integer currentMove) {
        this.currentMove = currentMove;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
