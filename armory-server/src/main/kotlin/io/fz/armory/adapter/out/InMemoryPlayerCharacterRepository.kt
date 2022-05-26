package io.fz.armory.adapter.out

import io.fz.armory.application.PlayerCharacterRepository
import io.fz.armory.domain.PlayerCharacter
import java.util.*
import java.util.concurrent.atomic.AtomicLong

class InMemoryPlayerCharacterRepository : PlayerCharacterRepository {
    private val characters: HashMap<Long, PlayerCharacter> = HashMap()
    private val sequence: AtomicLong = AtomicLong(0)

    override fun create(newCharacter: PlayerCharacter): PlayerCharacter {
        val id = sequence.getAndIncrement()
        newCharacter.id = id
        characters[sequence.getAndIncrement()] = newCharacter
        return newCharacter
    }

    override fun findById(idToLookFor: Long): Optional<PlayerCharacter> {
        return Optional.ofNullable(characters[idToLookFor])
    }


}
