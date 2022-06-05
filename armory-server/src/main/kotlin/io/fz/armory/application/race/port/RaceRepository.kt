package io.fz.armory.application.race.port

import io.fz.armory.domain.Race
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface RaceRepository {
    fun findAll(): Flux<Race>
    fun findById(id: String): Mono<Race>
}