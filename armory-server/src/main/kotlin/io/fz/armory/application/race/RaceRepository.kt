package io.fz.armory.application.race

import io.fz.armory.domain.Race
import reactor.core.publisher.Flux

interface RaceRepository {
    fun findAll(): Flux<Race>
}