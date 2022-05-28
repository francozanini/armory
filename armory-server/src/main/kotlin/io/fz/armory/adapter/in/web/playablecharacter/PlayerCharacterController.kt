package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.adapter.out.PlayerCharacterDocument
import io.fz.armory.adapter.out.PlayerCharacterDocumentRepository
import jakarta.validation.Valid
import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/playable-character")
class PlayerCharacterController @Autowired constructor(val playerCharacterDocumentRepository: PlayerCharacterDocumentRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid createCharacterCommand: CreateCharacterDTO): Publisher<PlayerCharacterDocument> {
        return playerCharacterDocumentRepository.save(
            PlayerCharacterDocument(
                null,
                createCharacterCommand.name,
                createCharacterCommand.race,
                createCharacterCommand.className,
                10,
                10,
                10,
                10,
                10,
                10
            )
        )
    }

    // dGpPlIe2HHSEf7RO
}

