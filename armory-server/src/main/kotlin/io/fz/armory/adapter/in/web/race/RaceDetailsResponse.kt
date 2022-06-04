package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.domain.Race

class RaceDetailsResponse(val raceName: String, val avatarUrl: String, val sourceBook: String) {
    companion object {
        fun from(race: Race) =
            RaceDetailsResponse(
                raceName = race.name.displayName(),
                avatarUrl = race.avatarUrl,
                sourceBook = race.sourceBook
            )
    }
}