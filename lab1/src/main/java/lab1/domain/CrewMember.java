package lab1.domain;

public class CrewMember {
    private String name;
    private String role; // Новая переменная: роль
    private boolean isActive; // Новая переменная: статус

    public CrewMember(String name, String role) {
        this.name = name;
        this.role = role;
        this.isActive = true; // По умолчанию активен
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}