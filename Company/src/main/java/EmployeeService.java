import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class EmployeeService {
    List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        Objects.requireNonNull(id,  "Id must not be null!");
        Objects.requireNonNull(name,  "Name must not be null!");
        Objects.requireNonNull(jobTitle,  "Job title must not be null!");

        if (id.isEmpty()) throw new IllegalArgumentException(STR."for id: '\{id}'");
        if (name.isEmpty()) throw new IllegalArgumentException(STR."for name: '\{name}'");
        if (jobTitle.isEmpty()) throw new IllegalArgumentException(STR."for job title: '\{jobTitle}'");

        Optional<Employee> employee = getEmployeeById(id);
        if (employee.isPresent()) throw new UserAlreadyExistsException(STR."User with ID '\{id}' already exists.");

        employees.add(new Employee(id.trim(), name.trim(), jobTitle.trim(), salary, dateOfEmployment));
        System.out.println("Successfully Hired.");
    }

    public void fire(String id) {
        Objects.requireNonNull(id,  "Id must not be null!");
        if (id.isEmpty()) throw new IllegalArgumentException(STR."for id: '\{id}'");

        Optional<Employee> employee = getEmployeeById(id.trim());
        if (employee.isEmpty()) throw new NoSuchElementException("User not found.");
        employees.remove(employee.get());
        System.out.println("Successfully removed.");
    }

    public void getEmployees() {
        if (employees.isEmpty()) throw new NoUsersFoundException("No users found.");
        employees.forEach(e -> System.out.println(e.toString()));
    }

    public void getEmployees(String jobTitle) {
        Objects.requireNonNull(jobTitle,  "Job title must not be null!");
        if (jobTitle.isEmpty()) throw new IllegalArgumentException(STR."for job title: '\{jobTitle}'");
        if (employees.isEmpty()) throw new NoUsersFoundException("No users found.");

        getEmployeesByJobTitle(jobTitle.trim()).forEach(System.out::println);
    }

    public void pay(String id) {
        Objects.requireNonNull(id,  "Id must not be null!");
        if (id.isEmpty()) throw new IllegalArgumentException(STR."for id: '\{id}'");

        Optional<Employee> employee = getEmployeeById(id.trim());
        if (employee.isEmpty()) throw new NoSuchElementException("User not found.");

        employee.get().addPaycheck(LocalDate.now());
        System.out.println("Successfully pay.");
    }

    public void increaseSalary (String id, double newSalary) {
        Objects.requireNonNull(id,  "Id must not be null!");
        if (id.isEmpty()) throw new IllegalArgumentException(STR."for id: '\{id}'");

        Optional<Employee> employee = getEmployeeById(id.trim());
        if (employee.isEmpty()) throw new NoSuchElementException("User not found.");

        employee.get().setNewSalary(newSalary);
        System.out.println("Salary Updated Successfully.");
    }

    public void averageSalary(String jobTitle) {
        Objects.requireNonNull(jobTitle,  "Job title must not be null!");
        if (jobTitle.isEmpty()) throw new IllegalArgumentException(STR."for job title: '\{jobTitle}'");

        OptionalDouble average = getEmployeesByJobTitle(jobTitle.trim())
                .mapToDouble(Employee::getSalary)
                .average();
        if (average.isPresent()) {
            System.out.printf("Average salaries with job title '%s': %.2f\n", jobTitle.trim(), average.getAsDouble());
        } else {
            System.out.printf("No employees found with job title '%s'.\n", jobTitle.trim());
        }
    }

    public void averageSalary(LocalDate initialDate, LocalDate finalDate) {
        OptionalDouble average = employees.stream()
                .mapToDouble(e -> getSumOfPaychecks(initialDate,finalDate,e))
                .average();
        if (average.isPresent()) {
            System.out.printf("Average salaries between these dates: %.2f\n", average.getAsDouble());
        } else {
            System.out.println("No employees have been paid between these dates.");
        }
    }

    private double getSumOfPaychecks(LocalDate initialDate, LocalDate finalDate, Employee e) {
        return PaycheckService.getSumOfPaychecks(initialDate, finalDate, e);
    }

    private Optional<Employee> getEmployeeById(String id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    private Stream<Employee> getEmployeesByJobTitle(String jobTitle) {
        return employees.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle));
    }
}
