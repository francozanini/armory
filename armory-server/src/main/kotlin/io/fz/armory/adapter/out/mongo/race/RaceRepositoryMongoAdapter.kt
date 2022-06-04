package io.fz.armory.adapter.out.mongo.race

import io.fz.armory.application.race.port.RaceRepository
import io.fz.armory.domain.Race
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class RaceRepositoryMongoAdapter(val raceDocumentRepository: RaceDocumentRepository) : RaceRepository {
    override fun findAll(): Flux<Race> {
        return raceDocumentRepository.findAll().map { it.toDomain() }
    }

}