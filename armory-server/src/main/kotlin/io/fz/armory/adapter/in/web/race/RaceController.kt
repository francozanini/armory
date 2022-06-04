package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.application.race.RaceRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/races")
class RaceController(val raceRepository: RaceRepository) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<RaceDetailsResponse> {
        return raceRepository.findAll().map { RaceDetailsResponse.from(it) }
    }

}

