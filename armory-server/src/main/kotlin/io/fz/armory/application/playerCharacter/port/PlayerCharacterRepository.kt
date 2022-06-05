package io.fz.armory.application.playerCharacter.port

import io.fz.armory.domain.PlayerCharacter
import reactor.core.publisher.Mono
import java.util.*

interface PlayerCharacterRepository {
    fun save(newCharacter: PlayerCharacter): Mono<PlayerCharacter>
    fun findById(idToLookFor: String): Mono<Optional<PlayerCharacter>>
}
