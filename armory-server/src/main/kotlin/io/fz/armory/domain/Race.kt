package io.fz.armory.domain

class Race(val name: RaceName) {

    var avatarUrl: String = ""
    var sourceBook: String = ""

    companion object {
        fun named(raceName: RaceName): Race = Race(raceName)
        fun named(raceName: RaceName, avatarUrl: String, sourceBook: String): Race {
            val race = Race(raceName)
            race.avatarUrl = avatarUrl
            race.sourceBook = sourceBook
            return race
        }

        val DWARF: Race = Race(RaceName.DWARF)
        val HUMAN: Race = Race(RaceName.HUMAN)
    }
}
