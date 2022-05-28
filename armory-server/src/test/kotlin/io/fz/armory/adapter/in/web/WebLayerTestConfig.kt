package io.fz.armory.adapter.`in`.web

import io.fz.armory.adapter.out.memory.InMemoryReactivePlayerCharacterRepository
import io.fz.armory.application.PlayerCharacterService
import io.fz.armory.application.PlayerCharacterServiceImpl
import io.fz.armory.application.ReactivePlayerCharacterRepository
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean


@TestConfiguration
class WebLayerTestConfig {
    @Bean
    fun reactivePlayerCharacterRepository(): ReactivePlayerCharacterRepository {
        return InMemoryReactivePlayerCharacterRepository()
    }

    @Bean
    fun playerCharacterService(pcRepository: ReactivePlayerCharacterRepository): PlayerCharacterService {
        return PlayerCharacterServiceImpl(pcRepository)
    }
}
