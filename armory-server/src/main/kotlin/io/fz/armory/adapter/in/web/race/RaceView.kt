package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.domain.Race

class RaceView(val id: String) {

    override fun equals(other: Any?): Boolean {
        return other != null && other is RaceView && other.id == this.id
    }

    companion object {
        fun from(race: Race): RaceView = RaceView(race.mongoId!!)
    }
}