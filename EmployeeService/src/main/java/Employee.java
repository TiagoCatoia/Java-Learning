import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Reportable {
    private String name;
    private LocalDate dateOfEmployment;
    private LocalDate yearsOfService;

    public Employee(String name, LocalDate dateOfEmployment, LocalDate yearsOfService) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;
        this.yearsOfService = yearsOfService;
    }

    @Override
    public String[] reportContent() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new String[]{name, dateOfEmployment.format(formatter), yearsOfService.format(formatter)};
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public LocalDate getYearsOfService() {
        return yearsOfService;
    }
}

