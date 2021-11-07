package com.kata;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import io.vavr.collection.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Unit test for simple BureauxService.
 */
public class BureauxServiceTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

    @Test
    public void allocationTest() {
        given().dixBureaux()
        .and().deuxGroupesDeTroisPersonnes();
        when().alloueLesBureaux();
        then().nombreDeBureauOccupe(2);
        then().nombreDeBureauLibre(8);
    }
}

class GivenSomeState extends Stage<GivenSomeState> {

    @ProvidedScenarioState
    private Bureaux bureaux;

    @ProvidedScenarioState
    private List<Groupe> groupes;

    public GivenSomeState dixBureaux() {
        this.bureaux = Bureaux.of(10);
        return self();
    }

    public GivenSomeState deuxGroupesDeTroisPersonnes() {
        this.groupes = List.fill(2, ()->new Groupe(3));
        return self();
    }
}

class WhenSomeAction extends Stage<WhenSomeAction> {

    @ScenarioState
    private Bureaux bureaux;

    @ScenarioState
    private List<Groupe> groupes;

    public WhenSomeAction alloueLesBureaux() {
        this.bureaux = this.bureaux.allouerLesBureaux(this.groupes);
        return self();
    }
}

class ThenSomeOutcome extends Stage<ThenSomeOutcome> {

    @ExpectedScenarioState
    private Bureaux bureaux;


    public ThenSomeOutcome nombreDeBureauOccupe(int nombreDeBureaux) {
        Assertions.assertThat(this.bureaux.nombreDeBureauOccupe()).isEqualTo(nombreDeBureaux);
        return self();
    }

    public ThenSomeOutcome nombreDeBureauLibre(int nombreDeBureaux) {
        Assertions.assertThat(this.bureaux.nombreDeBureauDisponibles()).isEqualTo(nombreDeBureaux);
        return self();
    }

}