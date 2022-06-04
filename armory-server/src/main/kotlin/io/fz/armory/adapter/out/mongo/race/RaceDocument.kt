package io.fz.armory.adapter.out.mongo.race

import io.fz.armory.domain.Race
import io.fz.armory.domain.RaceName
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class RaceDocument(
    @Id var mongoId: String?,
    var name: RaceName,
    var avatarUrl: String = "",
    var sourceBook: String = ""
) {
    fun toDomain(): Race = Race.named(name, avatarUrl, sourceBook)
}