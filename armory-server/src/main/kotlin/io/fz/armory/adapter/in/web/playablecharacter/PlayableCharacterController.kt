package io.fz.armory.adapter.`in`.web.playablecharacter

import jakarta.validation.Valid
import org.reactivestreams.Publisher
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/playable-character")
class PlayableCharacterController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid createCharacterCommand: CreateCharacterDto): Publisher<CreateCharacterDto> {
        return Mono.just(createCharacterCommand)
    }
}

