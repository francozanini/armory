package io.fz.armory.application

import io.fz.armory.adapter.out.memory.InMemoryPlayerCharacterRepository
import io.fz.armory.application.playerCharacter.PlayerCharacterServiceImpl
import io.fz.armory.application.playerCharacter.port.PlayerCharacterRepository
import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

internal class PlayerCharacterServiceImplTest {

    private lateinit var reactivePlayerCharacterRepository: PlayerCharacterRepository
    private lateinit var playerCharacterServiceImpl: PlayerCharacterServiceImpl

    @BeforeEach
    fun setUp() {
        reactivePlayerCharacterRepository = InMemoryPlayerCharacterRepository()
        playerCharacterServiceImpl = PlayerCharacterServiceImpl(reactivePlayerCharacterRepository)
    }

    @Test
    fun canCreate() {
        val bargusMono =
            playerCharacterServiceImpl.create(
                "Bargus",
                RaceName.DWARF,
                ClassName.CLERIC,
                Attributes(15, 10, 14, 8, 13, 12)
            )

        StepVerifier
            .create(bargusMono)
            .consumeNextWith { bargus ->
                assertThat(bargus.mongoId).isNotNull
                assertThat(reactivePlayerCharacterRepository.findById(bargus.mongoId!!).block()).isPresent
            }
            .verifyComplete()
    }
}