import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository extends GenericRepository<String, Employee> {
    private Map<String, Employee> db = new HashMap<>();

    @Override
    protected Map<String, Employee> getDatabase() {
        return db;
    }
}
