import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class EmployeeManagementService {
    private final EmployeeRepository repository;

    public EmployeeManagementService(EmployeeRepository employeeRepository) {
        repository = employeeRepository;
    }

    public void hire(String id, String name, String jobTitle, double salary) {
        Objects.requireNonNull(id, "Id must be not null!");
        Objects.requireNonNull(name, "Name must be not null!");
        Objects.requireNonNull(jobTitle, "Job title must be not null!");
        if(repository.findById(id).isPresent()) throw new EmployeeAlreadyExistsException("Employee id already exists!");
        repository.save(new Employee(id, name, jobTitle, salary, LocalDate.now()));
    }

    public void fire(String id) {
        Objects.requireNonNull(id, "Id must be not null!");
        if (repository.findById(id).isEmpty()) throw new NoSuchElementException("Employee not found");
        repository.deleteByKey(id);
    }

    public void pay(String id) {
        Objects.requireNonNull(id, "Id must be not null!");
        final Optional<Employee> employee = repository.findById(id);
        if (employee.isEmpty()) throw new NoSuchElementException("Employee not found");
        employee.get().addPaycheck(LocalDate.now());
    }

    public void increaseSalary(String id, double newSalary) {
        Objects.requireNonNull(id, "Id must be not null!");
        Optional<Employee> employee =  repository.findById(id);
        if (employee.isEmpty()) throw new NoSuchElementException("Employee not found");
        employee.get().setSalary(newSalary);
    }

    public double averageSalary(String jobTitle) {
        Objects.requireNonNull(jobTitle, "Job title must be not null!");
        return getStreamOfEmployeesByJobTitle(jobTitle).mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        if (start.isAfter(end) || end.isBefore(start)) throw new IllegalArgumentException(STR."Start date must be before the end date. for start date: \{start} and end date: \{end}");
        return getStreamOfEmployess()
                .flatMap(e -> e.getPaychecks().stream())
                .filter(paycheck -> !paycheck.getPayday().isBefore(start) && !paycheck.getPayday().isAfter(end))
                .mapToDouble(Paycheck::getSalary)
                .average()
                .orElse(0);
    }

    public List<Employee> getEmployees() {
        return getStreamOfEmployess().toList();
    }

    public List<Employee> getEmployees(String jobTitle) {
        Objects.requireNonNull(jobTitle, "Job title must be not null!");
        return getStreamOfEmployeesByJobTitle(jobTitle).toList();
    }

    private Stream<Employee> getStreamOfEmployeesByJobTitle(String jobTitle) {
        Objects.requireNonNull(jobTitle, "Job title must be not null!");
        return getStreamOfEmployess().filter(e -> e.getJobTitle().equals(jobTitle));
    }

    private Stream<Employee> getStreamOfEmployess() {
        return repository.findAll().stream();
    }
}
