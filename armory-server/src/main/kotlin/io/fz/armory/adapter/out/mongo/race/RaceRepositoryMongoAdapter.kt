package io.fz.armory.adapter.out.mongo.race

import io.fz.armory.application.race.port.RaceRepository
import io.fz.armory.domain.Race
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RaceRepositoryMongoAdapter(val raceDocumentRepository: RaceDocumentRepository) : RaceRepository {
    override fun findAll(): Flux<Race> {
        return raceDocumentRepository.findAll().map { it.toDomain() }
    }

    override fun findById(id: String): Mono<Race> {
        return raceDocumentRepository.findById(id).map { it.toDomain() }
    }

    override fun save(raceToSave: Race): Mono<Race> {
        return Mono
            .just(RaceDocument.from(raceToSave))
            .flatMap { raceDocumentRepository.save(it) }
            .map { it.toDomain() }
    }

}