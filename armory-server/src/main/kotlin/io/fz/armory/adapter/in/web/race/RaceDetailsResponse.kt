package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.domain.Race
import java.util.Optional.ofNullable

class RaceDetailsResponse(val raceName: String, val avatarUrl: String, val sourceBook: String, val id: String) {
    companion object {
        fun from(race: Race) =
            RaceDetailsResponse(
                id = ofNullable(race.mongoId).orElse(""),
                raceName = race.name.displayName(),
                avatarUrl = race.avatarUrl,
                sourceBook = race.sourceBook
            )
    }
}