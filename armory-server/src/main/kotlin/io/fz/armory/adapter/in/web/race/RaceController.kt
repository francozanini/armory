package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.application.race.port.RaceRepository
import io.fz.armory.domain.Race
import org.reactivestreams.Publisher
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux


@RestController
@RequestMapping("/races")
class RaceController(val raceRepository: RaceRepository) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): Flux<RaceDetailsResponse> {
        return raceRepository.findAll().map { RaceDetailsResponse.from(it) }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): Publisher<RaceDtoPeroConMasDetalles> {
        // ESTO DEBERÍA SER UN SERVICE QUE TIRE UNA EXCEPCIÓN SI NO LO ENCUENTRA.
        return raceRepository.findById(id).map { RaceDtoPeroConMasDetalles.from(it) }
    }

}

class RaceDtoPeroConMasDetalles {

    companion object {
        fun from(race: Race): RaceDtoPeroConMasDetalles = RaceDtoPeroConMasDetalles()
    }
}

