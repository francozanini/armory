package io.fz.armory.domain

class Race(val name: RaceName) {
    companion object {
        fun named(raceName: RaceName): Race = Race(raceName)

        val HUMAN: Race = Race(RaceName.HUMAN)
    }
}
