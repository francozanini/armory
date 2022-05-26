package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.application.PlayerCharacterService
import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PlayerCharacterServiceTest {

    private lateinit var playerCharacterService: PlayerCharacterService

    @BeforeEach
    fun setUp() {
        playerCharacterService = PlayerCharacterService()
    }

    @Test
    fun create() {
        playerCharacterService.create("Bargus", RaceName.DWARF, ClassName.CLERIC, Attributes(15, 10, 14, 8, 13, 12))
    }
}