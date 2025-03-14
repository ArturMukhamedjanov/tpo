package lab1;

import lab1.domain.CrewMember;
import lab1.domain.Mission;
import lab1.domain.SpaceTravel;
import lab1.domain.Spaceship;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SpaceTravelTest {

    @Test
    public void testCrewMember() {
        CrewMember member = new CrewMember("John Doe", "Captain");
        assertEquals("John Doe", member.getName());
        assertEquals("Captain", member.getRole());
        assertTrue(member.isActive());

        member.setActive(false);
        assertFalse(member.isActive());
    }

    @Test
    public void testSpaceship() {
        CrewMember captain = new CrewMember("John Doe", "Captain");
        CrewMember engineer = new CrewMember("Jane Smith", "Engineer");
        ArrayList<CrewMember> crew = new ArrayList<>();
        crew.add(captain);
        crew.add(engineer);

        Spaceship spaceship = new Spaceship("Starship", crew, 10);
        assertEquals("Starship", spaceship.getName());
        assertEquals(2, spaceship.getCrew().size());
        assertEquals("Ready", spaceship.getStatus());

        CrewMember doctor = new CrewMember("Alice Brown", "Doctor");
        assertEquals(true ,spaceship.addCrewMember(doctor));
        assertEquals(3, spaceship.getCrew().size());

        assertTrue(spaceship.removeCrewMember(doctor));
        assertEquals(2, spaceship.getCrew().size());
    }

    @Test
    public void testMission() {
        Mission mission = new Mission("Explore Mars", 365);
        assertEquals("Explore Mars", mission.getGoal());
        assertEquals(365, mission.getDuration());
        assertEquals("Planned", mission.getStatus());

        mission.setStatus("In Progress");
        assertEquals("In Progress", mission.getStatus());
    }

    @Test
    public void testSpaceTravel() {
        CrewMember captain = new CrewMember("John Doe", "Captain");
        CrewMember engineer = new CrewMember("Jane Smith", "Engineer");
        ArrayList<CrewMember> crew = new ArrayList<>();
        crew.add(captain);
        crew.add(engineer);

        Spaceship spaceship = new Spaceship("Starship", crew, 10);
        Mission mission = new Mission("Explore Mars", 365);

        SpaceTravel travel = new SpaceTravel(spaceship, mission);
        travel.startJourney();
        travel.endJourney();
        assertEquals("Completed", travel.mission.getStatus());
    }
}