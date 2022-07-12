package dev.fz.conclave.hex.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VampireCharacterTest {

    @Test
    public void createWithNameProvided() {
        var character = VampireCharacter.named("aName");

        assertThat(character.name()).isEqualTo("aName");
    }

    @Test
    public void nullNameBecomesEmptyName() {
        assertThat(VampireCharacter.named(null).name()).isEmpty();
    }


}