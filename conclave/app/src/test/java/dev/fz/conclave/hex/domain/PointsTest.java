package dev.fz.conclave.hex.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointsTest {

    @Test
    public void storesAmountGiven() {
        int amountGiven = 4;
        assertThat(Points.of(amountGiven).amount()).isEqualTo(amountGiven);
    }

    @Test
    public void isValueObject() {
        assertThat(Points.of(5)).isEqualTo(Points.of(5));
    }

    @Test
    public void amountCanNotBeHigherThanFive() {
        assertThatThrownBy(() -> Points.of(6))
                .isInstanceOf(InvalidAmountOfPointsException.class);
    }

    @Test
    public void amountCanNotBeNegative() {
        assertThatThrownBy(() -> Points.of(-5))
                .isInstanceOf(InvalidAmountOfPointsException.class);
    }
}