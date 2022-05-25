package io.fz.armory.domain

class PlayableCharacter private constructor(
    private val name: String,
    val race: Race,
    val playableClass: ClassName,
    strength: Int,
    dexterity: Int,
    constitution: Int,
    intelligence: Int,
    wisdom: Int,
    charisma: Int
) {

    constructor(
        name: String,
        strength: Int,
        dexterity: Int,
        constitution: Int,
        intelligence: Int,
        wisdom: Int,
        charisma: Int,
        playableClass: ClassName, raceName: RaceName
    ) : this(
        name,
        Race.named(raceName),
        playableClass,
        strength,
        dexterity,
        constitution,
        intelligence,
        wisdom,
        charisma
    )

    private val strength: Attribute
    private val dexterity: Attribute
    private val constitution: Attribute
    private val intelligence: Attribute
    private val wisdom: Attribute
    private val charisma: Attribute
    private val items: MutableList<Item>
    private var equippedArmor: Armor

    init {
        assertNameNotEmpty()
        this.strength = Attribute(strength)
        this.dexterity = Attribute(dexterity)
        this.constitution = Attribute(constitution)
        this.intelligence = Attribute(intelligence)
        this.wisdom = Attribute(wisdom)
        this.charisma = Attribute(charisma)
        items = arrayListOf()
        equippedArmor = Armor(10)
    }

    private fun assertNameNotEmpty() {
        if (name == "") throw RuntimeException(NAME_CAN_NOT_BE_EMPTY)
    }

    fun hasName(nameToCompare: String): Boolean = name == nameToCompare

    fun hasStrength(strengthToCompare: Int): Boolean = strength.equals(strengthToCompare)

    fun hasDexterity(dexterityToCompare: Int): Boolean = dexterity.equals(dexterityToCompare)

    fun addWeapon(weapon: Weapon) {
        addItem(weapon)
    }

    fun hasWeapon(weaponToLookFor: Weapon): Boolean {
        return hasItem(weaponToLookFor)
    }

    fun addArmor(armor: Armor) {
        addItem(armor)
    }

    private fun addItem(itemToAdd: Item) {
        items.add(itemToAdd)
    }

    fun hasItem(itemToLookFor: Item): Boolean = items.contains(itemToLookFor)

    fun ac(): Int {
        return equippedArmor.ac + dexterity.modifier()
    }

    fun equip(armorToEquip: Armor) {
        if (!hasItem(armorToEquip)) {
            addItem(armorToEquip)
        }

        equippedArmor = armorToEquip
    }

    companion object CreatureCompanion {
        const val NAME_CAN_NOT_BE_EMPTY = "Name can not be empty"

        fun named(name: String, raceName: RaceName, className: ClassName, attributes: Attributes) = PlayableCharacter(
            name,
            attributes.str,
            attributes.dex,
            attributes.con,
            attributes.int,
            attributes.wis,
            attributes.cha,
            className,
            raceName
        )

        fun named(
            name: String,
            strength: Int,
            dexterity: Int,
            constitution: Int,
            intelligence: Int,
            wisdom: Int,
            charisma: Int
        ) = PlayableCharacter(
            name,
            Race.HUMAN,
            ClassName.FIGHTER,
            strength,
            dexterity,
            constitution,
            intelligence,
            wisdom,
            charisma
        )
    }

}