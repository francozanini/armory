package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayableCharacter
import io.fz.armory.domain.RaceName

class PlayableCharacterService {
    fun create(name: String, race: RaceName, className: ClassName, attributes: Attributes) {
        val characterToCreate = PlayableCharacter.named(name, race, className, attributes)
    }
}