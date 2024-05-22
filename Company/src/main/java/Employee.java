import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final String id;
    private final String name;
    private String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;
    PaycheckService paycheckService;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        paycheckService = new PaycheckService();
    }

    public double getYearsOfService() {
        return Period.between(LocalDate.now(), dateOfEmployment).getYears();
    }

    public void addPaycheck(LocalDate payday) {
        paycheckService.addPaycheck(this, payday);
    }

    public void removePaycheck(Paycheck paycheck) {
        paycheckService.removePaycheck(this, paycheck);
    }

    public Iterator<Paycheck> iteratorPaycheck () {
        return paycheckService.iteratorPaycheck();
    }

    public void setNewSalary(double newSalary) {
        if (newSalary < salary) throw new IllegalArgumentException(STR."It is not possible to lower the salary. for salary: \{newSalary}");
        salary = newSalary;
    }

    @Override
    public String toString() {
        return STR."Employee{id='\{id}\{'\''}, name='\{name}\{'\''}, jobTitle='\{jobTitle}\{'\''}, salary=\{salary}, dateOfEmployment=\{dateOfEmployment}, paychecks=\{paycheckService.paychecks}\{'}'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
