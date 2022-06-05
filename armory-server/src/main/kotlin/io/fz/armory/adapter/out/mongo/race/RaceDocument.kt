package io.fz.armory.adapter.out.mongo.race

import io.fz.armory.domain.Race
import io.fz.armory.domain.RaceName
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class RaceDocument(
    @Id var id: String?,
    var name: RaceName,
    var avatarUrl: String = "",
    var sourceBook: String = ""
) {
    fun toDomain(): Race = Race.named(name, id, sourceBook, avatarUrl)
    override fun toString(): String = "id = $id, name = $name"

    companion object {
        fun from(raceToSave: Race): RaceDocument =
            RaceDocument(
                id = raceToSave.mongoId,
                name = raceToSave.name,
                avatarUrl = raceToSave.avatarUrl,
                sourceBook = raceToSave.sourceBook
            )
    }
}