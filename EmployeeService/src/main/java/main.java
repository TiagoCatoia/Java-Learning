import java.time.LocalDate;

void main() {
    Employee[] employees = {
            new Employee("Claude Shannon", LocalDate.parse("1940-01-27"), LocalDate.parse("1916-04-30")),
            new Employee("Edsger Dijkstra", LocalDate.parse("1958-03-17"), LocalDate.parse("1930-05-11")),
            new Employee("David Huffman", LocalDate.parse("1938-11-22"), LocalDate.parse("1925-07-09"))
    };
    // creates concrete implementations
    Formatter<Employee> formatter = new CsvFormatter<>();
    // use a factory to create SOME concrete implementation, indirectly.
    Exporter exporter = ExporterFactory.forTestingEnvironment();
    // creates the report service using dependency injection
    ReportService<Employee> reportService = new ReportService<>(formatter, exporter);  // It could be a report of Computers, Paychecks, etc … (just need implements Reportable)
    reportService.createReport(employees, null);
}