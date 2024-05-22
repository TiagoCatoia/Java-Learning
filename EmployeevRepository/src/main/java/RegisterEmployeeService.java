public class RegisterEmployeeService {
    Repository<Employee, String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public void register(Employee employee) {
        if (repository.getEntityById(employee.getId()) != null) {
            repository.saveEntity(employee);
        }
    }
}