import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private  LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int durationInMinuts() {
        return (this.endTime.toSecondOfDay() - this.startTime.toSecondOfDay()) / 60;
    }

    public String meetingAsString() {
        return "Description: " + this.description +
                ", Start Time: " + this.startTime +
                ", End Time: " + this.endTime +
                ", Duration: " + this.durationInMinuts() + " minutes";
    }

    public String getDescription() {
        return this.description;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }
}