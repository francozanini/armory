package dev.fz.conclave.hex.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SkillTest {

    @Test
    public void createsValidSkill() {
        assertThat(Skill.of("drive", 3).points()).isEqualTo(Points.of(3));
    }

}