package io.fz.armory.application.race.port

import io.fz.armory.domain.Race
import reactor.core.publisher.Flux

interface RaceRepository {
    fun findAll(): Flux<Race>
}