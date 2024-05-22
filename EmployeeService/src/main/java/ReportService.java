public class ReportService<T extends Reportable> {
    Formatter<T> formatter;
    Exporter exporter;

    public ReportService(Formatter<T> formatter, Exporter exporter) {
        this.formatter = formatter;
        this.exporter = exporter;
    }

    public void createReport(T[] elements, String destination) {
        final String content = formatter.format(elements);
        exporter.export(content, destination);
    }
}
