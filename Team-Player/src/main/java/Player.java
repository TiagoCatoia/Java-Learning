public class Player {
    private final String name;
    private final int number;
    private final Position position;
    private Boolean isFielded;
    private String team;

    public Player(String name, int number, Position position, Boolean isFielded) {
        if (number < 1 || number > 99) {
            throw new IllegalArgumentException("The number needs to be between 1 and 99.");
        }
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public String getStateAsString() {
        return "[" + name + ", " + number + ", " + position + ", " + team + ", " + isFielded + "]";
    }

    public Boolean getIsFielded() {
        return this.isFielded;
    }

    public void setIsFielded(Boolean isFielded) {
        this.isFielded = isFielded;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
