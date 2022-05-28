package io.fz.armory.adapter.out

import io.fz.armory.application.ReactivePlayerCharacterRepository
import io.fz.armory.domain.PlayerCharacter
import reactor.core.publisher.Mono
import java.util.*
import java.util.concurrent.atomic.AtomicLong

class InMemoryReactivePlayerCharacterRepository : ReactivePlayerCharacterRepository {
    private val characters: HashMap<Long, PlayerCharacter> = HashMap()
    private val sequence: AtomicLong = AtomicLong(0)

    override fun save(newCharacter: PlayerCharacter): Mono<PlayerCharacter> {
        val id = sequence.getAndIncrement()
        newCharacter.id = id
        characters[id] = newCharacter
        return Mono.just(newCharacter)
    }

    override fun findById(idToLookFor: Long): Mono<Optional<PlayerCharacter>> {
        return Mono.just(Optional.ofNullable(characters[idToLookFor]))
    }


}
