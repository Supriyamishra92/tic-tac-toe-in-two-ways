package com.fk.tic.tac.toe;

public class Cell {

    private Value value;

    public Cell() {
        this.value = Value.NONE;
    }

    public boolean isEmpty() {
        return value == Value.NONE;
    }

    public void mark(final Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
