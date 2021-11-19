package com.kata.domain;

import io.vavr.collection.List;

public class Bureaux {

    public static final int MIN_BUREAU = 0;
    public static final int MAX_BUREAU = 10;

    int nombreDeBureaux;
    int occupees = 0;

    public static Bureaux of(int nombreDeBureaux) {
        if (nombreDeBureaux< MIN_BUREAU)
            throw new IllegalArgumentException("pas assez de bureaux");
        if (nombreDeBureaux > MAX_BUREAU)
            throw new IllegalArgumentException("trop de bureaux");
        return new Bureaux(nombreDeBureaux);
    }

    private Bureaux(int nombreDeBureaux) {
        this.nombreDeBureaux = nombreDeBureaux;
    }

    public int quantityOfBureaux() {
        return nombreDeBureaux;
    }

    public Bureaux allouerLesBureaux(List<Groupe> groupes) {
        if (!isDisponible(groupes.length()))
            throw new IllegalArgumentException("pas assez de bureau à allouer");
        this.occupees = this.occupees+groupes.length();
        return this;
    }

    private boolean isDisponible(int quantityOfBureaux) {
        return nombreDeBureauDisponibles()>=quantityOfBureaux;
    }

    public int nombreDeBureauDisponibles() {
        return nombreDeBureaux - occupees;
    }

    public int nombreDeBureauOccupe() {
        return occupees;
    }
}
