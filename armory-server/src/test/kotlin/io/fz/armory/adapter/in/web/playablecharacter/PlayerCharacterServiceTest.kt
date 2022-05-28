package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.adapter.out.InMemoryReactivePlayerCharacterRepository
import io.fz.armory.application.PlayerCharacterService
import io.fz.armory.application.ReactivePlayerCharacterRepository
import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

internal class PlayerCharacterServiceTest {

    private lateinit var reactivePlayerCharacterRepository: ReactivePlayerCharacterRepository
    private lateinit var playerCharacterService: PlayerCharacterService

    @BeforeEach
    fun setUp() {
        reactivePlayerCharacterRepository = InMemoryReactivePlayerCharacterRepository()
        playerCharacterService = PlayerCharacterService(reactivePlayerCharacterRepository)
    }

    @Test
    fun create() {
        val bargusMono =
            playerCharacterService.create("Bargus", RaceName.DWARF, ClassName.CLERIC, Attributes(15, 10, 14, 8, 13, 12))
        
        StepVerifier
            .create(bargusMono)
            .consumeNextWith { bargus ->
                assertThat(bargus.id).isNotNull
                assertThat(reactivePlayerCharacterRepository.findById(bargus.id!!).block()).isPresent
            }
            .verifyComplete()
    }
}