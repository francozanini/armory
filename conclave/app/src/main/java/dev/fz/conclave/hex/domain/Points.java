package dev.fz.conclave.hex.domain;

public class Points {
    private final Integer amount;

    private Points(Integer amount) {
        this.amount = amount;
    }

    public static Points of(Integer amount) {
        requireInRange(amount);

        return new Points(amount);
    }

    private static void requireInRange(Integer amount) {
        if (amount > 5 || amount < 0) {
            throw new InvalidAmountOfPointsException();
        }
    }

    public Integer amount() {
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Points && amount.equals(((Points) other).amount);
    }
}
