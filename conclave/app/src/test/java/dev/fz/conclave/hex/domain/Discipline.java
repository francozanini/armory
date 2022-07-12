package dev.fz.conclave.hex.domain;

import java.util.List;

public class Discipline {
    private final DisciplineName name;
    private final List<ClanName> clans;

    private Discipline(DisciplineName name, ClanName clan) {
        if (name == null || clan == null) throw new InvalidDisciplineArguments();

        this.name = name;
        this.clans = List.of(clan);
    }

    public static Discipline named(DisciplineName name, ClanName clan) {
        return new Discipline(name, clan);
    }
}
