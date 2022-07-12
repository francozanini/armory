package dev.fz.conclave.hex.domain;

public class Attribute {
    private final AttributeName name;
    private final Integer points;

    private Attribute(AttributeName name, Integer points) {
        this.name = name;
        this.points = points;
    }

    public static Attribute of(AttributeName name, Integer points) {
        return new Attribute(name, points);
    }

    public static Attribute of(String name, Integer points) {
        return new Attribute(AttributeName.from(name), points);
    }

    public AttributeName name() {
        return name;
    }

    public Integer points() {
        return points;
    }

    public boolean is(AttributeName nameToCompareTo) {
        return name.equals(nameToCompareTo);
    }
}
