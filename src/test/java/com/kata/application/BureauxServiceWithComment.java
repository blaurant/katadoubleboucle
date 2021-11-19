package com.kata.application;

import com.kata.domain.Bureaux;
import com.kata.domain.Groupe;
import io.vavr.collection.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BureauxServiceWithComment {

    @Test
    public void reservation() {
        //GIVEN
        Bureaux bureaux = Bureaux.of(10);
        List<Groupe> groupes = List.fill(2, ()->new Groupe(3));
        //WHEN
        bureaux = new BureauxService(bureaux).allouerDesBureauxPour(groupes);
        //THEN
        Assertions.assertThat(bureaux.nombreDeBureauDisponibles()).isEqualTo(8);
        Assertions.assertThat(bureaux.nombreDeBureauOccupe()).isEqualTo(2);
    }
}
