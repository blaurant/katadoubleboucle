package com.kata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static com.kata.Bureau.State.OCCUPE;

public class BureauTest {

    @Test
    public void testInitialState() {
        Assertions.assertThat(new Bureau().isDisponible()).isTrue();
    }

    @Test
    public void isDisponible() {
        Assertions.assertThat(new Bureau().isDisponible()).isTrue();
    }

    @Test
    public void isOccupe() {
        Assertions.assertThat(new Bureau(OCCUPE).isOccupe()).isTrue();
    }

    @Test
    public void reserverSiDisponible() {
        Assertions.assertThat(new Bureau().reserver(new Groupe(2)).isOccupe()).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void reserverSiOccupe() {
        new Bureau(OCCUPE).reserver(new Groupe(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void reserverAvecTropDePersonne() {
        new Bureau(OCCUPE).reserver(new Groupe(Bureau.MAX_PERSONNES+1));
    }

}