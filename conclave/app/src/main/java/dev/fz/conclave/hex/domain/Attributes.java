package dev.fz.conclave.hex.domain;

import java.util.Collections;
import java.util.List;

public class Attributes {
    public static final int BASE_HP = 3;
    private final List<Attribute> values;

    private Attributes(List<Attribute> attributesChosen) {
        values = attributesChosen;
    }

    public static Attributes forNewCharacter(List<Attribute> attributesChosen) {
        requireValidForNewCharacter(attributesChosen);

        return new Attributes(attributesChosen);
    }

    private static void requireValidForNewCharacter(List<Attribute> attributesChosen) {
        boolean hasOneFour = attributesChosen.stream().mapToInt(Attribute::points).filter(points -> points == 4).count() == 1;
        boolean hasThreeThrees = attributesChosen.stream().mapToInt(Attribute::points).filter(points -> points == 3).count() == 3;
        boolean hasFourTwos = attributesChosen.stream().mapToInt(Attribute::points).filter(points -> points == 2).count() == 4;
        boolean hasOneOne = attributesChosen.stream().mapToInt(Attribute::points).filter(points -> points == 1).count() == 1;

        if (!(hasOneFour && hasThreeThrees && hasFourTwos && hasOneOne)) {
            throw new InvalidNewCharacterAttributes();
        }
    }

    public Integer pointsFor(AttributeName attributeToLookFor) {
        return values.stream()
                .filter(attribute -> attribute.is(attributeToLookFor))
                .findFirst()
                .map(Attribute::points)
                .orElseThrow();
    }

    public List<Attribute> values() {
        return Collections.unmodifiableList(values);
    }

    public Integer healthPoints() {
        return pointsFor(AttributeName.STAMINA) + BASE_HP;
    }

    public Points willpower() {
        return Points.of(pointsFor(AttributeName.RESOLVE) + pointsFor(AttributeName.COMPOSURE));
    }
}
