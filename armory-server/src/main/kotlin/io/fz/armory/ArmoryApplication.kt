package io.fz.armory

import io.fz.armory.adapter.out.mongo.race.RaceDocument
import io.fz.armory.adapter.out.mongo.race.RaceDocumentRepository
import io.fz.armory.domain.RaceName
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class ArmoryApplication

fun main(args: Array<String>) {
    runApplication<ArmoryApplication>(*args)
}

@Component
class ArmoryRunner(val raceRepository: RaceDocumentRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        raceRepository.deleteAll().subscribe { println("deleting $it") }

        val races = listOf(
            RaceDocument(
                id = null,
                name = RaceName.HUMAN,
                avatarUrl = "https://www.dndbeyond.com/avatars/316/819/636620994416798583.jpeg?width=1000&height=1000&fit=bounds&quality=95&auto=webp",
                sourceBook = "Player's Handbook"
            ),
            RaceDocument(
                id = null,
                name = RaceName.DWARF,
                avatarUrl = "https://www.dndbeyond.com/avatars/316/806/636620993762055484.jpeg?width=1000&height=1000&fit=bounds&quality=95&auto=webp",
                sourceBook = "Player's Handbook"
            ),
        )

        raceRepository.saveAll(races).subscribe { println("adding $it") }

    }

}