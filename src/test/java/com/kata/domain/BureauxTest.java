package com.kata.domain;

import io.vavr.collection.List;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BureauxTest {

    @Test(expected = IllegalArgumentException.class)
    public void pasAssezDeBureau() {
        Bureaux.of(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tropDeBureau() {
        Bureaux.of(11);
    }

    @Test
    public void nomberOfBureaux() {
        assertThat(Bureaux.of(5).quantityOfBureaux()).isEqualTo(5);
    }

    @Test
    public void allouerLesBureaux() {
        assertThat(Bureaux.of(10)
                .allouerLesBureaux(List.fill(2, new Groupe(3)))
                .nombreDeBureauDisponibles())
                .isEqualTo(8);
    }

}