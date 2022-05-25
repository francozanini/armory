package io.fz.armory

class Dices(private val amountOfDices: Int, private val faces: Int) {

    init {
        if (amountOfDices < 1) throw RuntimeException(AMOUNT_MUST_BE_POSITIVE)
        if (faces < 1) throw RuntimeException(FACES_MUST_BE_POSITIVE)
    }

    fun throwThem(): Int {
        var result = 0

        for (i in 1..amountOfDices) {
            result += ((Math.random() * (faces - 1) + 1)).toInt()
        }

        return result
    }

    companion object {
        const val FACES_MUST_BE_POSITIVE = "Faces must be a positive value"
        const val AMOUNT_MUST_BE_POSITIVE = "Amount of dices must be a positive value"
        val ONE_D_FOUR = Dices(1, 4)
    }

}
