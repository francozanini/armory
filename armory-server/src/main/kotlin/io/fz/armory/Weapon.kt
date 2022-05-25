package io.fz.armory

import Item

class Weapon private constructor(hitDice: Dices) : Item {

    companion object {
        private fun withDices(hitDice: Dices) = Weapon(hitDice)
        val DAGGER: Weapon = withDices(Dices.ONE_D_FOUR)
    }
}

