public class Athlete extends Person{
    private String skillLevel;

    public Athlete(String firstName, String lastName, String phoneNumber, String skillLevel) {
        super(firstName, lastName, phoneNumber);
        this.skillLevel = skillLevel;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public String toString() {
        return super.toString() + " - Skill Level: " + skillLevel;
    }
}