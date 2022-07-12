package dev.fz.conclave.hex.domain;

public enum AttributeName {
    STRENGTH,
    DEXTERITY,
    STAMINA,
    CHARISMA,
    MANIPULATION,
    COMPOSURE,
    INTELLIGENCE,
    WITS,
    RESOLVE;

    public static AttributeName from(String name) {
        return AttributeName.valueOf(name.toUpperCase());
    }
}
