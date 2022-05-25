package io.fz.armory.domain

class Armor(val ac: Int) : Item {
    companion object {
        fun withAC(ac: Int): Armor = Armor(ac)
    }

}
