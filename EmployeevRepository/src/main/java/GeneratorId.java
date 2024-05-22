import java.time.LocalTime;

import static java.lang.StringTemplate.STR;

public final class GeneratorId {
    private static int sequencialNumber = 10000;

    private GeneratorId(){};

    public static String generateId() {
        LocalTime now = LocalTime.now();
        return STR."\{now.getHour()}-\{now.getMinute()}-\{now.getSecond()}-\{sequencialNumber++}";
    }
}
