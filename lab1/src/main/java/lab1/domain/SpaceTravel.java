package lab1.domain;

public class SpaceTravel {
    public Spaceship spaceship;
    public Mission mission;

    public SpaceTravel(Spaceship spaceship, Mission mission) {
        this.spaceship = spaceship;
        this.mission = mission;
    }

    public void startJourney() {
        if (spaceship.getStatus().equals("Ready")) {
            System.out.println("Spaceship " + spaceship.getName() + " is starting its journey with crew:");
            for (CrewMember member : spaceship.getCrew()) {
                System.out.println(member.getName() + " (" + member.getRole() + ")");
            }
            mission.setStatus("In Progress");
            System.out.println("Mission: " + mission.getGoal() + " (Duration: " + mission.getDuration() + " days)");
        } else {
            System.out.println("Spaceship is not ready for the journey.");
        }
    }

    public void endJourney() {
        mission.setStatus("Completed");
        System.out.println("Mission completed: " + mission.getGoal());
    }
}