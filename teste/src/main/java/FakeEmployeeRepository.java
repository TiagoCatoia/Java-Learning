import java.util.ArrayList;
import java.util.List;

public class FakeEmployeeRepository {
    private final Employee[] employeeRepository;
    private int countEmployees = 0;

    public FakeEmployeeRepository() {
        this.employeeRepository = new Employee[100];
    };

    public FakeEmployeeRepository(Employee[] employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void add(Employee employee) {
        employeeRepository[countEmployees++] = employee;
    }

    public Employee[] getEmployees() {
        return employeeRepository;
    }
}
