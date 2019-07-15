package com.fk.tic.tac.toe;

public enum Value {

    NONE,
    NAUGHT,
    CROSS;

    @Override
    public String toString() {

        switch (this) {
            case CROSS:
                return "×";
            case NAUGHT:
                return "ø";
            case NONE:
            default:
                return "•";
        }
    }
}
