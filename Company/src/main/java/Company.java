import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Company {
    EmployeeService employeeService;

    public Company() {
        this.employeeService = new EmployeeService();
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        employeeService.hire(id, name, jobTitle, salary, dateOfEmployment);
    }

    public void fire(String id) {
       employeeService.fire(id);
    }

    public void getEmployees() {
        employeeService.getEmployees();
    }

    public void getEmployees(String jobTitle) {
        employeeService.getEmployees(jobTitle);
    }

    public void pay(String id) {
        employeeService.pay(id);
    }

    public void increaseSalary (String id, double newSalary) {
        employeeService.increaseSalary(id, newSalary);
    }

    public void averageSalary(String jobTitle) {
        employeeService.averageSalary(jobTitle);
    }

    public void averageSalary(LocalDate initialDate, LocalDate finalDate) {
        employeeService.averageSalary(initialDate, finalDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(employeeService.employees, company.employeeService.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(employeeService.employees);
    }
}
