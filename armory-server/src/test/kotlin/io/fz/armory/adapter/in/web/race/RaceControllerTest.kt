package io.fz.armory.adapter.`in`.web.race

import io.fz.armory.adapter.`in`.web.config.WebLayerTestConfig
import io.fz.armory.application.race.port.RaceRepository
import io.fz.armory.domain.Race
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@WebFluxTest(controllers = [RaceController::class])
@Import(WebLayerTestConfig::class)
internal class RaceControllerTest @Autowired constructor(
    private val raceRepository: RaceRepository,
    private val webClient: WebTestClient
) {

    @Test
    fun itFindsEmptyList() {
        webClient
            .get()
            .uri("/races")
            .exchange()
            .expectStatus().isOk
    }

    @Test
    fun itFindsSavedRace() {
        val savedRace = raceRepository.save(Race.HUMAN).block()

        webClient
            .get()
            .uri("/races/{id}", savedRace!!.mongoId)
            .exchange()
            .expectStatus().isOk
            .expectBody<RaceDtoPeroConMasDetalles>()
            .isEqualTo(RaceDtoPeroConMasDetalles.from(savedRace))
    }
}