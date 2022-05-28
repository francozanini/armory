package io.fz.armory.application

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayerCharacter
import io.fz.armory.domain.RaceName
import reactor.core.publisher.Mono

class PlayerCharacterService(private val reactivePlayerCharacterRepository: ReactivePlayerCharacterRepository) {
    fun create(name: String, race: RaceName, className: ClassName, attributes: Attributes): Mono<PlayerCharacter> {
        return Mono
            .just(PlayerCharacter.named(name, race, className, attributes))
            .flatMap { pc -> reactivePlayerCharacterRepository.save(pc) }
    }
}