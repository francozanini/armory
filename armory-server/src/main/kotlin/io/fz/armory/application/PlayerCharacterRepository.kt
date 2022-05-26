package io.fz.armory.application

import io.fz.armory.domain.PlayerCharacter
import java.util.*

interface PlayerCharacterRepository {
    fun create(newCharacter: PlayerCharacter): PlayerCharacter
    fun findById(idToLookFor: Long): Optional<PlayerCharacter>
}
