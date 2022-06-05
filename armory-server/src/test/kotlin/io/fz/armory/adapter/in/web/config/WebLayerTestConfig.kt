package io.fz.armory.adapter.`in`.web.config

import io.fz.armory.adapter.out.memory.InMemoryPlayerCharacterRepository
import io.fz.armory.adapter.out.memory.InMemoryRaceRepository
import io.fz.armory.application.playerCharacter.PlayerCharacterService
import io.fz.armory.application.playerCharacter.PlayerCharacterServiceImpl
import io.fz.armory.application.playerCharacter.port.PlayerCharacterRepository
import io.fz.armory.application.race.RaceService
import io.fz.armory.application.race.RaceServiceImpl
import io.fz.armory.application.race.port.RaceRepository
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean


@TestConfiguration
class WebLayerTestConfig {
    @Bean
    fun playerCharacterRepository(): PlayerCharacterRepository {
        return InMemoryPlayerCharacterRepository()
    }

    @Bean
    fun playerCharacterService(pcRepository: PlayerCharacterRepository): PlayerCharacterService {
        return PlayerCharacterServiceImpl(pcRepository)
    }

    @Bean
    fun raceRepository(): RaceRepository {
        return InMemoryRaceRepository()
    }

    @Bean
    fun raceService(raceRepository: RaceRepository): RaceService {
        return RaceServiceImpl(raceRepository)
    }
}
