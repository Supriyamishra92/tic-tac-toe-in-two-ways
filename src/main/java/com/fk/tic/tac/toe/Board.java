package com.fk.tic.tac.toe;

public class Board {

    private final Cell[][] cells;

    public Board(final int side) {

        cells = new Cell[side][side]; // boards are squares
        // by default, all cells have NULL values therefore are empty
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    // A method to check whether the board is complete (we have a winner or not)
    // returns true if there is a winner
    public boolean isDone() {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; ++j) {
                final Cell cell = cells[i][j];
                if (!cell.isEmpty()) {

                }
            }
        }

        return false;
    }

    public void mark(final Value value, final int x, final int y) {
        // add validation for x,y & if any value is already set
        final Cell cell = this.cells[x][y];
        if (!cell.isEmpty()) {
            throw new IllegalArgumentException("Already marked! Please choose another cell.");
        } else {
            cell.mark(value);
        }
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();

        for (final Cell[] cells : this.cells) {
            for (final Cell cell : cells) {
                sb.append(String.format("  %s  ", cell));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
