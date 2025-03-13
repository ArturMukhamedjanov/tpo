package lab1.domain;

import java.util.List;

public class Spaceship {
    private String name;
    private List<CrewMember> crew;

    public Spaceship(String name, List<CrewMember> crew) {
        this.name = name;
        this.crew = crew;
    }

    public String getName() {
        return name;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }
}
