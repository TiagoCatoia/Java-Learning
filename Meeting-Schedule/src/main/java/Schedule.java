import java.time.LocalDate;
import java.time.LocalTime;
import java.util.StringJoiner;

public class Schedule {
    private LocalDate day;
    private LocalTime starTime;
    private LocalTime endTime;
    private Meeting[] meetings; // ArrayList?
    private int countMeeting = 0;
    private static final int BASE_CAPACITY = 10;
    private static final int INCREMENT_CAPACITY = 10;

    public Schedule(LocalDate day, LocalTime starTime, LocalTime endTime) {
        this.day = day;
        this.starTime = starTime;
        this.endTime = endTime;
        this.meetings = new Meeting[BASE_CAPACITY];
    }

    public void addMeet(Meeting meeting) {
        if (countMeeting == meetings.length) {
            increaseCapacity();
        }
        if (checkMeetingTimeOverlap(meeting) && isOutsideWorking(meeting)) {
            this.meetings[this.countMeeting++] = meeting;
        }
    }

    private void increaseCapacity() {
        Meeting[] newMeetings = new Meeting[meetings.length + INCREMENT_CAPACITY];
        System.arraycopy(meetings, 0, newMeetings, 0, meetings.length);
        this.meetings = newMeetings;
    }

    private boolean checkMeetingTimeOverlap(Meeting meeting) {
        for (Meeting eachMeeting : this.meetings) {
            if (eachMeeting == null) continue;
            if (meeting.getStartTime().toSecondOfDay() < eachMeeting.getStartTime().toSecondOfDay() && meeting.getEndTime().toSecondOfDay() <= eachMeeting.getStartTime().toSecondOfDay()) {
                continue;
            } else if (meeting.getStartTime().toSecondOfDay() >= eachMeeting.getEndTime().toSecondOfDay() && meeting.getEndTime().toSecondOfDay() > eachMeeting.getEndTime().toSecondOfDay()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isOutsideWorking(Meeting meeting) {
        return (meeting.getStartTime().toSecondOfDay() >= this.starTime.toSecondOfDay() && meeting.getEndTime().toSecondOfDay() <= this.endTime.toSecondOfDay());
    }

    public void removeMeet(Meeting meeting) {
        for (int i = 0; i < countMeeting; i++) {
            Meeting auxMeeting;
            if (meetings[i] != null && meetings[i].equals(meeting)) {
                auxMeeting = this.meetings[this.meetings.length-1];
                this.meetings[this.meetings.length-1] = null;
                meetings[i] = auxMeeting;
                countMeeting--;
                break;
            }
        }
    }

    public double percentageSpendInMeetings() {
        int spendTimeMettings = 0;
        for (Meeting meeting: this.meetings) {
            if (meeting == null) continue;
            spendTimeMettings += meeting.durationInMinuts();
        }
        return ((double) spendTimeMettings / ((double) (this.endTime.toSecondOfDay() - this.starTime.toSecondOfDay()) /60) * 100);
    }

    public String scheduleAsString() {
        StringJoiner joiner = new StringJoiner(", ","[","]");
        for (Meeting meeting: this.meetings) {
            if (meeting == null) continue;
            String meetingString =
                    "Description: " + meeting.getDescription() +
                    ", Start Time: " + meeting.getStartTime() +
                    ", End Time: " + meeting.getEndTime();
            joiner.add(meetingString);
        }
        return joiner.toString();
    }

    public LocalDate getDay() {
        return day;
    }

    public LocalTime getStarTime() {
        return starTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getLenght() {
        return this.meetings.length;
    }
}
