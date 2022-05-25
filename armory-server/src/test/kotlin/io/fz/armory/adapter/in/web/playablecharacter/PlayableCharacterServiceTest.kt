package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PlayableCharacterServiceTest {

    private lateinit var playableCharacterService: PlayableCharacterService

    @BeforeEach
    fun setUp() {
        playableCharacterService = PlayableCharacterService()
    }

    @Test
    fun create() {
        playableCharacterService.create("Bargus", RaceName.DWARF, ClassName.CLERIC, Attributes(15, 10, 14, 8, 13, 12))
    }
}