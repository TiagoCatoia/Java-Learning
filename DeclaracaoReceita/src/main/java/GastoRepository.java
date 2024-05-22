import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GastoRepository extends GenericRepository<Long, Gasto> {
    private static final Map<Long, Gasto> db = new LinkedHashMap<>();
    private static long id = 1;

    @Override
    protected Map<Long, Gasto> getDatabase() {
        return db;
    }

    public static long nextId() {
        return id++;
    }
}
