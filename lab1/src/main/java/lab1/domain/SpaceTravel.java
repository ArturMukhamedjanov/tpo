package lab1.domain;

public class SpaceTravel {
    private Spaceship spaceship;

    public SpaceTravel(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public void startJourney() {
        System.out.println("Spaceship " + spaceship.getName() + " is starting its journey with crew:");
        for (CrewMember member : spaceship.getCrew()) {
            System.out.println(member.getName());
        }
    }
}
