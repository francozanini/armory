package dev.fz.conclave.hex.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DisciplineTest {

    @Test
    public void canNotCreateWithoutName() {
        assertThatThrownBy(() -> Discipline.named(null, ClanName.VENTRUE))
                .isInstanceOf(InvalidDisciplineArguments.class);
    }

    @Test
    public void canNotCreateWithoutClanName() {
        assertThatThrownBy(() -> Discipline.named(DisciplineName.AUSPEX, null))
                .isInstanceOf(InvalidDisciplineArguments.class);
    }

}