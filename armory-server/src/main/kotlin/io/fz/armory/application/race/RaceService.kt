package io.fz.armory.application.race

import io.fz.armory.domain.Race
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface RaceService {
    fun findById(id: String): Mono<Race>
    fun findAll(): Flux<Race>

}
