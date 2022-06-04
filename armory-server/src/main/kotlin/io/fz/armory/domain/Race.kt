package io.fz.armory.domain

class Race(val name: RaceName) {

    var mongoId: String? = null
    var avatarUrl: String = ""
    var sourceBook: String = ""

    companion object {
        fun named(raceName: RaceName): Race = Race(raceName)
        fun named(raceName: RaceName, sourceBook: String, avatarUrl: String): Race {
            return named(raceName, null, sourceBook, avatarUrl)
        }

        fun named(raceName: RaceName, mongoId: String?, sourceBook: String, avatarUrl: String): Race {
            return named(raceName).apply {
                this.avatarUrl = avatarUrl
                this.sourceBook = sourceBook
                this.mongoId = mongoId
            }
        }

        val DWARF: Race = Race(RaceName.DWARF)
        val HUMAN: Race = Race(RaceName.HUMAN)
    }
}
