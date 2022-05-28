package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.application.PlayerCharacterService
import io.fz.armory.application.ReactivePlayerCharacterRepository
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters


@WebFluxTest(controllers = [PlayerCharacterController::class])
internal class PlayerCharacterControllerTest {

    @MockBean
    lateinit var playerCharacterService: PlayerCharacterService

    @MockBean
    lateinit var pcRepository: ReactivePlayerCharacterRepository

    @Autowired
    lateinit var webClient: WebTestClient

    @Test
    fun create() {
        val createCharacterDTO =
            CreateCharacterDTO("Aristos", ClassName.FIGHTER, RaceName.HUMAN, AttributesDTO(15, 12, 14, 8, 10, 12))

        this.webClient
            .post()
            .uri("/playable-character")
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(createCharacterDTO))
            .exchange()
            .expectStatus().isCreated
    }
}