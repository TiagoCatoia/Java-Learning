import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    public Employee(String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        id = GeneratorId.generateId();
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService() {
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public double calculateBonus() {
        if (dateOfEmployment.getYear() > 2000) {
            return 15;
        }
        return 5;
    }

    public String getId() {
        return id;
    }
}
