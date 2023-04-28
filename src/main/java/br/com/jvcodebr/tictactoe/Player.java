package br.com.jvcodebr.tictactoe;

public class Player {
    private String name;
    private Simbol simbol;

    public Player(String name, Simbol simbol) {
        this.name = name;
        this.simbol = simbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Simbol getSimbol() {
        return simbol;
    }

    public void setSimbol(Simbol simbol) {
        this.simbol = simbol;
    }
}
