package io.fz.armory

import Item

class Armor(val ac: Int) : Item {
    companion object {
        fun withAC(ac: Int): Armor = Armor(ac)
    }

}
