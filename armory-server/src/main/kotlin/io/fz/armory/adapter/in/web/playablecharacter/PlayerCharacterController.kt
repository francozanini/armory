package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.application.playerCharacter.PlayerCharacterService
import jakarta.validation.Valid
import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/player-characters")
class PlayerCharacterController @Autowired constructor(val playerCharacterService: PlayerCharacterService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid createCharacterCommand: CreateCharacterCommand): Publisher<CharacterDetailsResponse> {
        return playerCharacterService.create(
            createCharacterCommand.name,
            createCharacterCommand.race,
            createCharacterCommand.className,
            createCharacterCommand.attributes.toDomain()
        ).map { CharacterDetailsResponse.fromDomain(it) }
    }
}

