package io.fz.armory.application.playerCharacter

import io.fz.armory.application.playerCharacter.port.PlayerCharacterRepository
import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayerCharacter
import io.fz.armory.domain.RaceName
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlayerCharacterServiceImpl(private val pcRepository: PlayerCharacterRepository) :
    PlayerCharacterService {

    override fun create(
        name: String,
        race: RaceName,
        className: ClassName,
        attributes: Attributes
    ): Mono<PlayerCharacter> {
        return pcRepository.save(PlayerCharacter.named(name, race, className, attributes))
    }

}