package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.domain.ClassName
import io.fz.armory.domain.PlayerCharacter
import io.fz.armory.domain.RaceName

@Suppress("unused")
class CharacterDetailsResponse private constructor(
    val id: String?,
    val name: String,
    val race: RaceName,
    val ClassName: ClassName
) {

    companion object {
        fun fromDomain(pc: PlayerCharacter) =
            CharacterDetailsResponse(pc.mongoId(), pc.name(), pc.raceName(), pc.className())
    }
}
