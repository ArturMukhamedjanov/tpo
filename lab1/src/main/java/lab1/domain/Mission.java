package lab1.domain;

public class Mission {
    private String goal;
    private int duration; // Продолжительность в днях
    private String status; // Статус миссии

    public Mission(String goal, int duration) {
        this.goal = goal;
        this.duration = duration;
        this.status = "Planned"; // По умолчанию запланирована
    }

    public String getGoal() {
        return goal;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}