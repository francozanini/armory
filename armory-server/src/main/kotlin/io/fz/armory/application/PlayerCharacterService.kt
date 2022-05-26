package io.fz.armory.application

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayerCharacter
import io.fz.armory.domain.RaceName

class PlayerCharacterService(val PlayerCharacterRepository: PlayerCharacterRepository) {
    fun create(name: String, race: RaceName, className: ClassName, attributes: Attributes) {
        val characterToCreate = PlayerCharacter.named(name, race, className, attributes)
    }
}