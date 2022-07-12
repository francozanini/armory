package dev.fz.conclave.hex.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttributesTest {

    @Test
    void canCreateWithNewCharacterValidations() {
        List<Attribute> startingValues = List.of(
                Attribute.of("strength", 4),
                Attribute.of("dexterity", 3),
                Attribute.of("stamina", 3),
                Attribute.of("charisma", 3),
                Attribute.of("manipulation", 2),
                Attribute.of("composure", 2),
                Attribute.of("intelligence", 2),
                Attribute.of("wits", 2),
                Attribute.of("resolve", 1));

        Attributes attributes = Attributes.forNewCharacter(startingValues);

        assertThat(attributes.values()).containsExactlyElementsOf(startingValues);

    }

    @Test
    void canQueryForSpecificAttribute() {
        List<Attribute> startingValues = List.of(
                Attribute.of("strength", 4),
                Attribute.of("dexterity", 3),
                Attribute.of("stamina", 3),
                Attribute.of("charisma", 3),
                Attribute.of("manipulation", 2),
                Attribute.of("composure", 2),
                Attribute.of("intelligence", 2),
                Attribute.of("wits", 2),
                Attribute.of("resolve", 1));

        Attributes attributes = Attributes.forNewCharacter(startingValues);

        assertThat(attributes.pointsFor(AttributeName.STRENGTH)).isEqualTo(4);
        assertThat(attributes.pointsFor(AttributeName.DEXTERITY)).isEqualTo(3);
        assertThat(attributes.pointsFor(AttributeName.STAMINA)).isEqualTo(3);
        assertThat(attributes.pointsFor(AttributeName.CHARISMA)).isEqualTo(3);
        assertThat(attributes.pointsFor(AttributeName.MANIPULATION)).isEqualTo(2);
        assertThat(attributes.pointsFor(AttributeName.COMPOSURE)).isEqualTo(2);
        assertThat(attributes.pointsFor(AttributeName.INTELLIGENCE)).isEqualTo(2);
        assertThat(attributes.pointsFor(AttributeName.RESOLVE)).isEqualTo(1);
    }

    @Test
    void calculatesCorrectStartingHealth() {
        List<Attribute> startingValues = List.of(
                Attribute.of("strength", 4),
                Attribute.of("dexterity", 3),
                Attribute.of("stamina", 3),
                Attribute.of("charisma", 3),
                Attribute.of("manipulation", 2),
                Attribute.of("composure", 2),
                Attribute.of("intelligence", 2),
                Attribute.of("wits", 2),
                Attribute.of("resolve", 1));

        Attributes attributes = Attributes.forNewCharacter(startingValues);

        assertThat(attributes.healthPoints()).isEqualTo(6);
    }

    @Test
    void calculatesCorrectStartingWillpower() {
        List<Attribute> startingValues = List.of(
                Attribute.of("strength", 4),
                Attribute.of("dexterity", 3),
                Attribute.of("stamina", 3),
                Attribute.of("charisma", 3),
                Attribute.of("manipulation", 2),
                Attribute.of("composure", 2),
                Attribute.of("intelligence", 2),
                Attribute.of("wits", 2),
                Attribute.of("resolve", 1));

        Attributes attributes = Attributes.forNewCharacter(startingValues);

        assertThat(attributes.willpower()).isEqualTo(Points.of(3));
    }

    @Test
    public void throwsExceptionWhenNotUsingNewCharacterValues() {
        List<Attribute> invalidAttributes = List.of(
                Attribute.of("strength", 5),
                Attribute.of("dexterity", 3),
                Attribute.of("stamina", 3),
                Attribute.of("charisma", 2),
                Attribute.of("manipulation", 2),
                Attribute.of("composure", 2),
                Attribute.of("intelligence", 2),
                Attribute.of("wits", 2),
                Attribute.of("resolve", 1));

        assertThatThrownBy(() -> Attributes.forNewCharacter(invalidAttributes))
                .isInstanceOf(InvalidNewCharacterAttributes.class);
    }
}