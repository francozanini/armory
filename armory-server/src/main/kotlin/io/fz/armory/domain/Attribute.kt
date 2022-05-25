package io.fz.armory.domain

class Attribute(private val value: Int) {
    init {
        if (value !in 0..20) throw RuntimeException(ATTRIBUTE_OUT_OF_BOUNDS)
    }

    fun equals(valueToCompare: Int): Boolean = value == valueToCompare

    fun modifier(): Int {
        return when (value) {
            in 0..1 -> -5
            in 2..3 -> -4
            in 4..5 -> -3
            in 6..7 -> -2
            in 8..9 -> -1
            in 10..11 -> 0
            in 12..13 -> 1
            in 14..15 -> 2
            in 16..17 -> 3
            in 18..19 -> 4
            else -> 5
        }
    }

    companion object Constants {
        const val ATTRIBUTE_OUT_OF_BOUNDS = "The attribute should be above -1 and below 21"
    }
}