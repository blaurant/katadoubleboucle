package com.kata;

import io.vavr.collection.List;

import static com.kata.Bureau.disponible;
import static com.kata.Bureau.occupe;

public class Bureaux {

    public static final int MIN_BUREAU = 0;
    public static final int MAX_BUREAU = 10;

    private List<Bureau> bureaux;

    public static Bureaux of(int nombreDeBureaux) {
        if (nombreDeBureaux< MIN_BUREAU)
            throw new IllegalArgumentException("pas assez de bureaux");
        if (nombreDeBureaux > MAX_BUREAU)
            throw new IllegalArgumentException("trop de bureaux");
        return new Bureaux(List.fill(nombreDeBureaux, ()->new Bureau()));
    }

    private Bureaux(List<Bureau> bureaux) {
        this.bureaux = bureaux;
    }

    public int quantityOfBureaux() {
        return bureaux.length();
    }

    public Bureaux allouerLesBureaux(List<Groupe> groupes) {
        if (onlyDisponible().quantityOfBureaux() <= groupes.length())
            throw new IllegalArgumentException("pas assez de bureau à allouer");
        //TODO refactor this section
        Bureaux result = this;
        for (int i=0; i<groupes.length(); i++) {
            Groupe groupe = groupes.get(i);
            result = result.allouer(groupe);
        }
        return result;
    }

    public Bureaux allouer(Groupe groupe) {
        if (onlyDisponible().quantityOfBureaux() <= 1)
            throw new IllegalArgumentException("plus de bureau à allouer");
        Bureau bureau = this.bureaux.filter(disponible()).head();
        return new Bureaux(bureaux.replace(bureau, bureau.reserver(groupe)));
    }

    public int nombreDeBureauDisponibles() {
        return bureaux.filter(disponible()).length();
    }

    public int nombreDeBureauOccupe() {
        return bureaux.filter(occupe()).length();
    }

    public Bureaux onlyDisponible() {
        return new Bureaux(bureaux.filter(disponible()));
    }
}
