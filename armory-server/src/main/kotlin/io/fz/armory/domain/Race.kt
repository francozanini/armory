package io.fz.armory.domain

class Race(val name: RaceName) {
    companion object {
        val HUMAN: Race = Race(RaceName.HUMAN)
    }
}
