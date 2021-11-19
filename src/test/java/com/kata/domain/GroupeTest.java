package com.kata.domain;

import org.junit.Test;

public class GroupeTest {

    @Test(expected = IllegalArgumentException.class)
    public void pasAssezDePersonnes() {
        new Groupe(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tropAssezDePersonnes() {
        new Groupe(11);
    }
}