package io.fz.armory.adapter.out.mongo.playerCharacter

import io.fz.armory.application.playerCharacter.ReactivePlayerCharacterRepository
import io.fz.armory.domain.PlayerCharacter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class PlayerCharacterRepositoryMongoAdapter @Autowired constructor(private val pcDocumentRepository: PlayerCharacterDocumentRepository) :
    ReactivePlayerCharacterRepository {

    override fun save(newCharacter: PlayerCharacter): Mono<PlayerCharacter> {
        return Mono.just(newCharacter)
            .map { PlayerCharacterDocument.fromDomain(it) }
            .flatMap { pcDocumentRepository.insert(it) }
            .map { it.toDomain() }
    }

    override fun findById(idToLookFor: String): Mono<Optional<PlayerCharacter>> {
        return pcDocumentRepository.findById(idToLookFor)
            .map { document -> Optional.ofNullable(document).map { it.toDomain() } }
    }
}