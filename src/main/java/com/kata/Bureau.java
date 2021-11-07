package com.kata;

import java.util.function.Predicate;

import static com.kata.Bureau.State.DISPONIBLE;
import static com.kata.Bureau.State.OCCUPE;

public class Bureau {

    public enum State {DISPONIBLE, OCCUPE;}

    public static final int MAX_PERSONNES = 6;

    private State state;

    public Bureau() {
        this(DISPONIBLE);
    }

    Bureau(State state) {
        this.state = state;
    }

    public boolean isDisponible() {
        return state.equals(DISPONIBLE);
    }

    public boolean isOccupe() {
        return state.equals(OCCUPE);
    }

    public Bureau reserver(Groupe groupe) {
        if (!isDisponible())
            throw new IllegalArgumentException("le bureau n'est pas disponible");
        if (groupe.nombreDePersonnes() > capacite())
            throw new IllegalArgumentException("le groupe excede la capacite du bureau");
        return new Bureau(OCCUPE);
    }

    private int capacite() {
        return MAX_PERSONNES;
    }

    public static Predicate<Bureau> disponible() {
        return bureau -> bureau.isDisponible();
    }

    public static Predicate<Bureau> occupe() {
        return bureau -> bureau.isOccupe();
    }
}
