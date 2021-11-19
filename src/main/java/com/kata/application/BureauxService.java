package com.kata.application;

import com.kata.domain.Bureaux;
import com.kata.domain.Groupe;
import io.vavr.collection.List;

import java.util.Objects;

public class BureauxService {

    public final Bureaux bureaux;


    public BureauxService(Bureaux bureaux) {
        this.bureaux = Objects.requireNonNull(bureaux);
    }

    public Bureaux allouerDesBureauxPour(List<Groupe> groupes) {
        return this.bureaux.allouerLesBureaux(groupes);
    }
}
