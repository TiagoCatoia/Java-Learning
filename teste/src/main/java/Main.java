import java.time.LocalDate;

public static void main(String[] args) {
    FakeEmployeeRepository employeeRepository = new FakeEmployeeRepository();
    employeeRepository.add(new Employee("Claude Shannon", LocalDate.parse("1940-01-27"), LocalDate.parse("1916-04-30")));
    employeeRepository.add(new Employee("Edsger Dijkstra", LocalDate.parse("1958-03-17"), LocalDate.parse("1930-05-11")));
    employeeRepository.add(new Employee("David Huffman", LocalDate.parse("1938-11-22"), LocalDate.parse("1925-07-09")));

    Formatter<Employee> formatter = new CsvFormatter<>();
    Exporter exporter = (content, _) -> System.out.println(content);
    ReportService<Employee> reportService = new ReportService<>((c, _) -> System.out.println(c), formatter);
    reportService.createReport(employeeRepository.getEmployees(), "legends.csv");
}
