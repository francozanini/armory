package io.fz.armory.adapter.out

import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class PlayerCharacterDocument(
    @Id var id: String?,
    var name: String,
    var raceName: RaceName,
    var playableClass: ClassName,
    var strength: Int,
    var dexterity: Int,
    var constitution: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charisma: Int
)