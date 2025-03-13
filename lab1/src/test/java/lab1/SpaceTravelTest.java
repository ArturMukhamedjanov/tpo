package lab1;

import lab1.domain.CrewMember;
import lab1.domain.SpaceTravel;
import lab1.domain.Spaceship;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SpaceTravelTest {

    @Test
    public void testSpaceTravel() {
        CrewMember member1 = new CrewMember("Alice");
        CrewMember member2 = new CrewMember("Bob");
        Spaceship spaceship = new Spaceship("Golden Heart", Arrays.asList(member1, member2));
        SpaceTravel travel = new SpaceTravel(spaceship);

        travel.startJourney();
        assertEquals("Golden Heart", spaceship.getName());
        assertEquals(2, spaceship.getCrew().size());
    }
}