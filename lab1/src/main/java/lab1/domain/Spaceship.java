package lab1.domain;

import java.util.ArrayList;
import java.util.List;

public class Spaceship {
    private String name;
    private ArrayList<CrewMember> crew;
    private int capacity; // Новая переменная: вместимость
    private String status; // Новая переменная: статус корабля

    public Spaceship(String name, ArrayList<CrewMember> crew, int capacity) {
        this.name = name;
        this.crew = crew;
        this.capacity = capacity;
        this.status = "Ready"; // По умолчанию готов к полёту
    }

    public String getName() {
        return name;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean addCrewMember(CrewMember member) {
        if (crew.size() < capacity) {
            crew.add(member);
            return true;
        }
        return false;
    }

    public boolean removeCrewMember(CrewMember member) {
        return crew.remove(member);
    }
}