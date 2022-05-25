package CreateCharacterCommand

import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName

data class CreateCharacterCommand(
    val name: String,
    val className: ClassName,
    val race: RaceName,
    val attributes: AttributesDTO
)

data class AttributesDTO(val str: Int, val dex: Int, val con: Int, val int: Int, val wis: Int, val cha: Int)
