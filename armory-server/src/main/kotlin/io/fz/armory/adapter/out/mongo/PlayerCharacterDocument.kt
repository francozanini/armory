package io.fz.armory.adapter.out.mongo

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayerCharacter
import io.fz.armory.domain.RaceName
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "playerCharacterDocument")
class PlayerCharacterDocument(
    @Id var id: String?,
    var name: String,
    var raceName: RaceName,
    var className: ClassName,
    var strength: Int,
    var dexterity: Int,
    var constitution: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charisma: Int
) {

    fun toDomain(): PlayerCharacter {
        return PlayerCharacter.named(
            mongoId = id,
            name,
            raceName,
            className,
            Attributes(
                strength,
                dexterity,
                constitution,
                intelligence,
                wisdom,
                charisma
            )
        )
    }

    companion object {
        fun fromDomain(pcToMap: PlayerCharacter): PlayerCharacterDocument {
            return PlayerCharacterDocument(
                id = pcToMap.mongoId(),
                name = pcToMap.name(),
                raceName = pcToMap.raceName(),
                className = pcToMap.className(),
                strength = pcToMap.str().value(),
                dexterity = pcToMap.dex().value(),
                constitution = pcToMap.con().value(),
                intelligence = pcToMap.int().value(),
                wisdom = pcToMap.wis().value(),
                charisma = pcToMap.cha().value()
            )
        }


    }
}