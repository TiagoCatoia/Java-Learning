import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.lang.StringTemplate.STR;

public class Employee implements Entity<String> {
    private String id;
    private String name;
    private String  jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;
    private List<Paycheck> paychecks;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        paychecks = new ArrayList<>();
    }



    public void addPaycheck(LocalDate payday) {
        paychecks.add(new Paycheck(payday, salary));
    }

    public void removePaycheck(Paycheck paycheck) {
        paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaycheck() {
        return paychecks.iterator();
    }

    @Override
    public String key() {
        return getId();
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

    @Override
    public String toString() {
        return STR."Employee{id='\{id}\{'\''}, name='\{name}\{'\''}, jobTitle='\{jobTitle}\{'\''}, salary=\{salary}, dateOfEmployment=\{dateOfEmployment}, paychecks=\{paychecks}\{'}'}";
    }

    public void setSalary(double newSalary) {
        if (newSalary < salary) throw new IllegalArgumentException(STR."It is not possible to lower the salary. for salary: \{newSalary}");
        salary = newSalary;
    }

    public List<Paycheck> getPaychecks() {
        return paychecks;
    }

    public double getYearsOfService() {
        return ChronoUnit.YEARS.between(dateOfEmployment, LocalDate.now());
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getName() {
        return name;
    }
}
