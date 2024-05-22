import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits FullTimeEmployee, PerHourEmployee{
    protected String id;
    protected String name;
    protected String jobTitle;
    protected LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    public abstract double salary();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerHourEmployee that = (PerHourEmployee) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }
}
