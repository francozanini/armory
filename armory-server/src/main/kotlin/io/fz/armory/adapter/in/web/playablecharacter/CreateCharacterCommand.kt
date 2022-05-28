package io.fz.armory.adapter.`in`.web.playablecharacter

import io.fz.armory.domain.Attributes
import io.fz.armory.domain.ClassName
import io.fz.armory.domain.RaceName
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateCharacterCommand(
    @NotBlank(message = "name can not be blank") val name: String,
    @NotNull(message = "must provide className") val className: ClassName,
    @NotNull(message = "must provide race") val race: RaceName,
    @NotNull(message = "must provide attribute") val attributes: AttributesDTO
)

data class AttributesDTO(
    @NotNull val str: Int,
    @NotNull val dex: Int,
    @NotNull val con: Int,
    @NotNull val int: Int,
    @NotNull val wis: Int,
    @NotNull val cha: Int
) {
    fun toDomain(): Attributes = Attributes(str, dex, con, int, wis, cha)

}
