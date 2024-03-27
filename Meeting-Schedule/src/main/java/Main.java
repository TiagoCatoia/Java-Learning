import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDate day = LocalDate.of(2024, 3, 20);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(20, 0);
        Schedule schedule = new Schedule(day, startTime, endTime);

        Meeting meeting1 = new Meeting("Brainstorming Session", LocalTime.of(9, 0), LocalTime.of(9, 45));
        Meeting meeting2 = new Meeting("Project Update Meeting", LocalTime.of(10, 0), LocalTime.of(10, 45));
        Meeting meeting3 = new Meeting("Team Training Workshop", LocalTime.of(11, 0), LocalTime.of(11, 45));
        Meeting meeting4 = new Meeting("Weekly Team Standup", LocalTime.of(12, 0), LocalTime.of(12, 30));
        Meeting meeting5 = new Meeting("Client Presentation", LocalTime.of(13, 0), LocalTime.of(13, 45));
        Meeting meeting6 = new Meeting("Budget Review", LocalTime.of(14, 0), LocalTime.of(14, 45));
        Meeting meeting7 = new Meeting("Marketing Strategy Meeting", LocalTime.of(15, 0), LocalTime.of(15, 45));
        Meeting meeting8 = new Meeting("Monthly Review Meeting", LocalTime.of(16, 0), LocalTime.of(16, 45));
        Meeting meeting9 = new Meeting("Training Session", LocalTime.of(17, 0), LocalTime.of(17, 45));
        Meeting meeting10 = new Meeting("Team Building Activity", LocalTime.of(18, 0), LocalTime.of(18, 45));
        Meeting meeting11 = new Meeting("Customer Feedback Session", LocalTime.of(19, 0), LocalTime.of(19, 45));


        schedule.addMeet(meeting1);
        schedule.addMeet(meeting2);
        schedule.addMeet(meeting3);
        schedule.addMeet(meeting4);
        schedule.addMeet(meeting5);
        schedule.addMeet(meeting6);
        schedule.addMeet(meeting7);
        schedule.addMeet(meeting8);
        schedule.addMeet(meeting9);
        schedule.addMeet(meeting10);
        schedule.addMeet(meeting11);

        System.out.println("\nLenght: " + schedule.getLenght());


        System.out.println(" ");
        System.out.println(schedule.scheduleAsString());
        System.out.println("Removendo a reunião 'Project Update Meeting'...");
        schedule.removeMeet(meeting2);
        System.out.println(schedule.scheduleAsString());

        System.out.println("\nAgenda atualizada:");
        System.out.println("Agenda for " + schedule.getDay());
        System.out.println("Working Hours: " + schedule.getStarTime() + " - " + schedule.getEndTime());
        System.out.println("Meetings:");
        System.out.println(schedule.scheduleAsString());

        double percentage = schedule.percentageSpendInMeetings();
        System.out.println("\nPercentage of time spent in meetings: " + String.format("%.2f", percentage) + "%");

        System.out.println("\nTentando adicionar uma reunião com horário incompatível...");
        Meeting incompatibleMeeting = new Meeting("Incompatible Meeting", LocalTime.of(16, 0), LocalTime.of(17, 30));
        schedule.addMeet(incompatibleMeeting);
        System.out.println(schedule.scheduleAsString());
    }
}