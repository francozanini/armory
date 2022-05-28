package io.fz.armory.application

import io.fz.armory.domain.PlayerCharacter
import reactor.core.publisher.Mono
import java.util.*

interface ReactivePlayerCharacterRepository {
    fun save(newCharacter: PlayerCharacter): Mono<PlayerCharacter>
    fun findById(idToLookFor: Long): Mono<Optional<PlayerCharacter>>
}
