package io.fz.armory.adapter.out.memory

import io.fz.armory.application.race.port.RaceRepository
import io.fz.armory.domain.Race
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

class InMemoryRaceRepository : RaceRepository {
    private val idToRaceMap = ConcurrentHashMap<String, Race>()
    private val sequence = AtomicLong(0)

    override fun findAll(): Flux<Race> {
        return Flux.fromStream(idToRaceMap.values.stream())
    }

    override fun save(raceToSave: Race): Mono<Race> {
        if (raceToSave.mongoId == null) {
            raceToSave.mongoId = sequence.getAndIncrement().toString()
        }

        idToRaceMap[raceToSave.mongoId!!] = raceToSave

        return Mono.just(raceToSave)
    }

    override fun findById(id: String): Mono<Race> {
        return Mono.justOrEmpty(idToRaceMap[id])
    }

}
