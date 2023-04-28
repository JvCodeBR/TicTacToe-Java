package br.com.jvcodebr.tictactoe;

public enum Simbol {
    CIRCLE((char) 88),
    CROSS((char) 48);

    private final char simbol;

    Simbol(char simbol) {
        this.simbol = simbol;
    }
    public char getSimbol() {
        return this.simbol;
    }
}
