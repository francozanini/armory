package io.fz.armory.adapter.out.memory

import io.fz.armory.application.playerCharacter.ReactivePlayerCharacterRepository
import io.fz.armory.domain.PlayerCharacter
import reactor.core.publisher.Mono
import java.util.*
import java.util.concurrent.atomic.AtomicLong

class InMemoryReactivePlayerCharacterRepository : ReactivePlayerCharacterRepository {
    private val characters: HashMap<String, PlayerCharacter> = HashMap()
    private val sequence: AtomicLong = AtomicLong(0)

    override fun save(newCharacter: PlayerCharacter): Mono<PlayerCharacter> {
        val id = sequence.getAndIncrement().toString()
        newCharacter.mongoId = id
        characters[id] = newCharacter
        return Mono.just(newCharacter)
    }

    override fun findById(idToLookFor: String): Mono<Optional<PlayerCharacter>> {
        return Mono.just(Optional.ofNullable(characters[idToLookFor]))
    }


}
