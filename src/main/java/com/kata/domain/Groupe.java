package com.kata.domain;

public class Groupe {
    private static final int MIN_GROUPE = 0;
    private static final int MAX_GROUPE = 10;

    private final int nombreDePersonnes;

    public Groupe(int nombreDePersonnes) {
        if (nombreDePersonnes < MIN_GROUPE)
            throw new IllegalArgumentException("pas assez de personnes");
        if (nombreDePersonnes > MAX_GROUPE)
            throw new IllegalArgumentException("trop de personnes");
        this.nombreDePersonnes = nombreDePersonnes;
    }

    public int nombreDePersonnes() {
        return nombreDePersonnes;
    }
}
