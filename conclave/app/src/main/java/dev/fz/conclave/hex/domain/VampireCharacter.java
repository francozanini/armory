package dev.fz.conclave.hex.domain;

import java.util.Objects;

public class VampireCharacter {


    private final String name;

    public VampireCharacter(String aName) {
        name = Objects.requireNonNullElse(aName, "");
    }

    public static VampireCharacter named(String aName) {
        return new VampireCharacter(aName);
    }

    public String name() {
        return name;
    }
}
