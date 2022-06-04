package io.fz.armory.application.playerCharacter

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayerCharacter
import io.fz.armory.domain.RaceName
import reactor.core.publisher.Mono

interface PlayerCharacterService {
    fun create(name: String, race: RaceName, className: ClassName, attributes: Attributes): Mono<PlayerCharacter>
}
