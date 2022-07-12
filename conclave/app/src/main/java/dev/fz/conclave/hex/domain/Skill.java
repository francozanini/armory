package dev.fz.conclave.hex.domain;

public class Skill {
    private final Points points;
    private final SkillName name;

    private Skill(SkillName name, Points points) {
        this.points = points;
        this.name = name;
    }

    public static Skill of(SkillName name, Integer amount) {
        return new Skill(name, Points.of(amount));
    }

    public static Skill of(String skillName, int amount) {
        return of(SkillName.valueOf(skillName.toUpperCase()), amount);
    }

    public Points points() {
        return points;
    }
}
