package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.application.race.RaceService
import org.reactivestreams.Publisher
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux


@RestController
@RequestMapping("/races")
class RaceController(val raceService: RaceService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<RaceDetailsResponse> {
        return raceService.findAll().map { RaceDetailsResponse.from(it) }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): Publisher<RaceView> {
        return raceService.findById(id).map { RaceView.from(it) }
    }

}

