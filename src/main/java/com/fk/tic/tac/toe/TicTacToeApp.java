package com.fk.tic.tac.toe;

import java.util.Scanner;

public class TicTacToeApp {

    public static void main(String[] args) {

        System.out.println("Tic-Tac-Toe!");
        System.out.println();
        System.out.println("===================================");
        System.out.println();
        System.out.println("Instructions:");
        System.out.println("   1. Each player has to take turns");
        System.out.println("   2. At the prompt, enter the coordinate (0 based)");
        System.out.println();

        Value currentMove = Value.CROSS;
        final Scanner scanner = new Scanner(System.in);

        final Board board = new Board(3);
        // Game loop
        while (!Thread.interrupted() || !board.isDone()) {

            boolean moveIsValid;
            do {
                moveIsValid = true;
                System.out.printf("Current move for %s: ", currentMove);
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                try {
                    board.mark(currentMove, x, y);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    moveIsValid = false;
                }
            } while (!moveIsValid);

            System.out.println(board);
            currentMove = currentMove == Value.CROSS ? Value.NAUGHT : Value.CROSS;
        }
    }
}
