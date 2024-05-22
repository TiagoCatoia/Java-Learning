import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Employee implements Reportable{
    private String name;
    private LocalDate dateOfEmployment;
    private LocalDate birthDate;

    public Employee(String name, LocalDate dateOfEmployment, LocalDate birthDate) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;
        this.birthDate = birthDate;
    }

    @Override
    public String[] reportContent() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        return new String[]{name, dateOfEmployment.format(formatter), birthDate.format(formatter), String.valueOf(getYearsOfService())};
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Object getYearsOfService() {
        return Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), dateOfEmployment));
    }
}
