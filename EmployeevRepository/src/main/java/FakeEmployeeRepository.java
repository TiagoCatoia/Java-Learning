public class FakeEmployeeRepository implements Repository<Employee, String> {
    private Employee[] employees;
    private int countEmployees;

    public FakeEmployeeRepository() {
        employees = new Employee[100];
    }

    @Override
    public void saveEntity(Employee employee) {
        if (countEmployees == 100) return;
        employees[countEmployees++] = employee;
    }

    @Override
    public Employee getEntityById(String id) {
        for (Employee employee: employees) {
            if (employee == null) return null;
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
}
