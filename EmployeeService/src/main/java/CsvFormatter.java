import java.util.StringJoiner;

import static java.lang.StringTemplate.STR;

public class CsvFormatter<T extends Reportable> implements Formatter<T> {

    @Override
    public String format(T[] elements) {
        StringJoiner joiner = new StringJoiner("\n");
        for (T t: elements) {
            final Reportable reportable = (Reportable) t;
            final String[] content = reportable.reportContent();
            joiner.add(String.join(",", content));
        }
        return joiner.toString();
    }
}
