package org.example;

public class Player {
    private int id;
    private int counterId = 0;
    private String name;
    private int strength;
    public Player(String name, int strength) {
        this.id = ++counterId;
        this.name = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}