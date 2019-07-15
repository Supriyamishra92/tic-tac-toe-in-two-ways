package com.practice.tic.tac.toe;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {

    private char[][] gameBoard;
    private boolean gameStatus = true;

    /*
    * This is a constructor
    *
    *
    * */

    public GameBoard() {

        gameBoard = new char[3][3];

        for (int row = 0; row < gameBoard.length; row++) {

            Arrays.fill(gameBoard[row], ' ') ;
        }
    }

    /*
    * the constructor ends here
    * */

    /*
    *This method is to display the Board
    * */

    public void displayBoard() {

        for ( int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++ ) {
                System.out.print("\t"+ gameBoard[row][col]);
                if (col == 0 || col == 1) {
                    System.out.print("|");
                }
            }
            if (row == 0 || row == 1) {
                System.out.print("\n-----------------\n");
            }
            System.out.println();
        }
    }
    /*
     * end of display the Board
     * */

    /*
    * This method will return true if it is active
    * */
    public boolean isGameActive() {

        return gameStatus;
    }

    public boolean makeMove(char player, int row, int col) {

        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {

            if (gameBoard[row][col] != ' ') {
                return  false;
            } else {
                gameBoard[row][col] = player;
                return true;
            }
        }

        return false;
    }

    /* This method will ask to pick row and col and call
    and validate the input and call makeMove function
    * */

    public void askPlayer(char player) {
        Scanner input = new Scanner(System.in);
        int row, col;
        do {
            System.out.printf("Player %s please enter the row [1-3] :  ", player);
            row = input.nextInt();

            System.out.printf("Player %s please enter the col [1-3] :  ", player);
            col = input.nextInt();

        } while (notValid(row, col));

        makeMove(player, row-1, col-1);

    }
    /*
    * this method will return true if move is not valid*/


    public boolean notValid(int row, int col) {

        if (row > 3 || row < 1 || col  > 3 || col < 1 || !isEmpty(row,col)) {
            return true;
        } else {

            return  false;

        }
    }

    public boolean isEmpty(int row, int col) {
        if (gameBoard[row-1][col-1] == ' ') {
            return  true;
        } else {
            System.out.println("This position has been taken \n ");
            return false;
        }
    }

    public boolean checkForWinner() {
        for (int row  = 0; row < gameBoard.length; row++) {

            if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2] && gameBoard[row][0] != ' ' ) {

                System.out.println(" The Winner is : " + gameBoard[row][0]);
                gameStatus = false;
            }
        }

        for (int col = 0; col < gameBoard.length; col++) {
            if (gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col] && gameBoard[0][col] !=' ') {
                gameStatus = false;
                System.out.println(" The Winner is : " + gameBoard[0][col]);

            }
        }

        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') {
            System.out.println(" The Winner is : " + gameBoard[0][0]);
            gameStatus = false;
        }

        if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2] && gameBoard[0][2] != ' ') {
            System.out.println(" The Winner is : " + gameBoard[1][1]);
            gameStatus = false;
        }

        return false;



    }
}
