import java.util.StringJoiner;

public class CsvFormatter <T extends Reportable> implements Formatter <T>{
    @Override
    public String format(T[] elements) {
        StringJoiner joiner = new StringJoiner("\n");
        for (T t : elements) {
            if (t == null) break;;
            final String[] content = t.reportContent();
            joiner.add(String.join(",", content));
        }
        return joiner.toString();
    }
}
