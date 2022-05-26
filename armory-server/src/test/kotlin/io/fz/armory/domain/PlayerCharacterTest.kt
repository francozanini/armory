package io.fz.armory.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PlayerCharacterTest {

    @Test
    fun canCreate() {
        val creature = creatureNamed("abc")
        assertThat(creature.hasName("abc")).isTrue
        assertThat(creature.hasStrength(10)).isTrue
        assertThat(creature.hasDexterity(10)).isTrue
    }

    @Test
    fun canNotCreateWithEmptyName() {
        val ex = assertThrows<RuntimeException> { PlayerCharacter.named("", 10, 15, 15, 16, 29, 19) }
        assertThat(ex.message).isEqualTo(PlayerCharacter.NAME_CAN_NOT_BE_EMPTY)
    }

    @Test
    fun canNotCreateWithAttributesAboveRange() {
        val ex = assertThrows<RuntimeException> { PlayerCharacter.named("abc", 21, 15, 15, 16, 29, 19) }
        assertThat(ex.message).isEqualTo(Attribute.ATTRIBUTE_OUT_OF_BOUNDS)
    }

    @Test
    fun canAddWeaponToInventory() {
        val weapon = Weapon.DAGGER
        val creature = bargus()

        creature.addWeapon(weapon)

        assertThat(creature.hasWeapon(Weapon.DAGGER)).isTrue
    }

    @Test
    fun shouldReturnFalseWhenCreatureDoesntHaveWeapon() {
        val creature = bargus()
        assertThat(creature.hasWeapon(Weapon.DAGGER)).isFalse
    }

    @Test
    fun canAddArmorToInventory() {
        val armor = Armor.withAC(10)
        val creature = bargus()

        creature.addArmor(armor)

        assertThat(creature.hasItem(armor)).isTrue
    }

    @Test
    fun returnsFalseWhenCreatureDoesntHaveItem() {
        val creature = bargus()
        assertThat(creature.hasItem(Armor.withAC(10))).isFalse
    }

    @Test
    fun `calculates AC with no modifier`() {
        assertThat(bargus().ac()).isEqualTo(10)
    }

    @Test
    fun `calculates AC with DEX modifier`() {
        val bashVonBlades = bashVonBlades()
        assertThat(bashVonBlades.ac()).isEqualTo(11)
    }

    @Test
    fun `calculates AC with DEX modifier and cloth armor`() {
        val bashVonBlades = bashVonBlades()
        bashVonBlades.equip(Armor(12))
        assertThat(bashVonBlades.ac()).isEqualTo(13)
    }

    private fun bashVonBlades() = PlayerCharacter.named("bash von blades", 10, 12, 10, 10, 10, 10)

    private fun creatureNamed(name: String) = PlayerCharacter.named(name, 10, 10, 15, 16, 20, 1)

    private fun bargus() = creatureNamed("Bargus")
}
