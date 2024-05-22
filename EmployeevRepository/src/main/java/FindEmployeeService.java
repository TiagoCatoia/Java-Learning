public class FindEmployeeService {
    Repository<Employee, String> repository;

    public FindEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public Employee findById(String id) {
        return repository.getEntityById(id);
    }
}
