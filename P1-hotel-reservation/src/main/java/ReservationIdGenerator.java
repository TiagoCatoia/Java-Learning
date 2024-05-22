import java.time.LocalTime;

public class ReservationIdGenerator {
    private static int sequencialNumber = 10000;
    private ReservationIdGenerator(){};
    public static String id() {
        LocalTime time = LocalTime.now();
        return String.valueOf("HT" + "-" + time.getMinute() + "-" + time.getSecond() + "-" + sequencialNumber++);
    }
}
