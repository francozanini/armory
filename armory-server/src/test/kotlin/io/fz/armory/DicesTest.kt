package io.fz.armory

import io.fz.armory.domain.Dices
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DicesTest {

    @Test
    fun canNotCreateWithNonPositiveAmountOfDices() {
        val ex = assertThrows<RuntimeException> { Dices(0, 4) }
        Assertions.assertThat(ex.message).isEqualTo(Dices.AMOUNT_MUST_BE_POSITIVE)
    }

    @Test
    fun canNotCreateWithNonPositiveFaces() {
        val ex = assertThrows<RuntimeException> { Dices(2, 0) }
        Assertions.assertThat(ex.message).isEqualTo(Dices.FACES_MUST_BE_POSITIVE)
    }
}