package io.fz.armory

import Creature
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CreatureTest {

    @Test
    fun canCreate() {
        val creature = Creature("abc", 10, 15, 15, 16, 20, 1)
        assertThat(creature.hasName("abc")).isTrue
        assertThat(creature.hasStrength(10)).isTrue
        assertThat(creature.hasDexterity(15)).isTrue
    }

    @Test
    fun canNotCreateWithEmptyName() {
        val ex = assertThrows<RuntimeException> { Creature("", 10, 15, 15, 16, 29, 19) }
        assertThat(ex.message).isEqualTo(Creature.NAME_CAN_NOT_BE_EMPTY)
    }

    @Test
    fun canNotCreateWithAttributesAboveRange() {
        val ex = assertThrows<RuntimeException> { Creature("abc", 21, 15, 15, 16, 29, 19) }
        assertThat(ex.message).isEqualTo(Attribute.ATTRIBUTE_OUT_OF_BOUNDS)
    }


}