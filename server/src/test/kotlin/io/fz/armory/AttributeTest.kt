package io.fz.armory

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class AttributeTest {
    @Test
    fun returnsNeutralModifier() {
        Assertions.assertThat(Attribute(10).modifier()).isEqualTo(0)
    }

    @Test
    fun returnsPositiveModifier() {
        Assertions.assertThat(Attribute(12).modifier()).isEqualTo(1)
    }

    @Test
    fun returnsNegativeModifier() {
        Assertions.assertThat(Attribute(9).modifier()).isEqualTo(-1)
    }
}