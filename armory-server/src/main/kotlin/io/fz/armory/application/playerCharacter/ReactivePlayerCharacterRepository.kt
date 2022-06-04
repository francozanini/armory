package io.fz.armory.application.playerCharacter

import io.fz.armory.domain.PlayerCharacter
import reactor.core.publisher.Mono
import java.util.*

interface ReactivePlayerCharacterRepository {
    fun save(newCharacter: PlayerCharacter): Mono<PlayerCharacter>
    fun findById(idToLookFor: String): Mono<Optional<PlayerCharacter>>
}
