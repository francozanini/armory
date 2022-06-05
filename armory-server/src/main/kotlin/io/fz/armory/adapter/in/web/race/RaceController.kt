package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.application.race.RaceService
import io.fz.armory.domain.Race
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
    fun findById(@PathVariable id: String): Publisher<RaceDtoPeroConMasDetalles> {
        return raceService.findById(id).map { RaceDtoPeroConMasDetalles.from(it) }
    }

}

class RaceDtoPeroConMasDetalles(val id: String) {

    override fun equals(other: Any?): Boolean {
        return other != null && other is RaceDtoPeroConMasDetalles && other.id == this.id
    }

    companion object {
        fun from(race: Race): RaceDtoPeroConMasDetalles = RaceDtoPeroConMasDetalles(race.mongoId!!)
    }
}

