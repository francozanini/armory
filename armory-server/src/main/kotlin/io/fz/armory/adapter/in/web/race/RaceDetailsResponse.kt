package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.domain.Race

class RaceDetailsResponse(val raceName: String, val avatarUrl: String, val sourceBook: String) {
    companion object {
        fun from(raceToMap: Race) =
            RaceDetailsResponse(
                raceName = raceToMap.name.displayName(),
                avatarUrl = "blabla",
                sourceBook = "Players Handbook"
            )
    }
}