package io.fz.armory.domain

enum class RaceName {
    HUMAN,
    DWARF;

    fun displayName(): String = this.name[0].uppercase() + this.name.substring(1)

}
