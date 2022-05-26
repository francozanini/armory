package io.fz.armory.application

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayerCharacter
import io.fz.armory.domain.RaceName

class PlayerCharacterService(val playerCharacterRepository: PlayerCharacterRepository) {
    fun create(name: String, race: RaceName, className: ClassName, attributes: Attributes): PlayerCharacter {
        val characterToCreate = PlayerCharacter.named(name, race, className, attributes)
        return playerCharacterRepository.create(characterToCreate)
    }
}