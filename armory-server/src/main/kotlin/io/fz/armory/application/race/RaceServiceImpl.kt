package io.fz.armory.application.race

import io.fz.armory.application.race.port.RaceRepository
import io.fz.armory.domain.Race
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RaceServiceImpl(private val raceRepository: RaceRepository) : RaceService {
    override fun findById(id: String): Mono<Race> {
        return Mono.justOrEmpty(id)
            .flatMap { raceRepository.findById(id) }
            .switchIfEmpty(Mono.error(RuntimeException("Race not found")))
    }

    override fun findAll(): Flux<Race> {
        return raceRepository.findAll()
    }
}