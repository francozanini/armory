import io.fz.armory.Attribute

class Creature(
    private val name: String,
    strength: Int,
    dexterity: Int,
    constitution: Int,
    intelligence: Int,
    wisdom: Int,
    charisma: Int
) {

    private val strength: Attribute
    private val dexterity: Attribute
    private val constitution: Attribute
    private val intelligence: Attribute
    private val wisdom: Attribute
    private val charisma: Attribute

    init {
        assertNameNotEmpty()
        this.strength = Attribute(strength)
        this.dexterity = Attribute(dexterity)
        this.constitution = Attribute(constitution)
        this.intelligence = Attribute(intelligence)
        this.wisdom = Attribute(wisdom)
        this.charisma = Attribute(charisma)
    }

    private fun assertNameNotEmpty() {
        if (name == "") throw RuntimeException(NAME_CAN_NOT_BE_EMPTY)
    }

    fun hasName(nameToCompare: String): Boolean = name == nameToCompare

    fun hasStrength(strengthToCompare: Int): Boolean = strength.equals(strengthToCompare)
    fun hasDexterity(dexterityToCompare: Int): Boolean = dexterity.equals(dexterityToCompare)

    companion object Constants {
        const val NAME_CAN_NOT_BE_EMPTY = "Name can not be empty"
    }

}