import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class  GenericRepository <K, T extends Entity <K>> {
    protected abstract Map<K, T> getDatabase();

    public void save(T type) {
        getDatabase().put(type.key(), type);
    }

    public void delete(T type) {
        getDatabase().values().remove(type);
    }

    public void deleteByKey(K key) {
        getDatabase().remove(key);
    }

    public void update(T type) {
        getDatabase().replace(type.key(), type);
    }

    public Optional<T> findByKey(K key) {
        return Optional.ofNullable(getDatabase().get(key));
    }

    public List<T> findAll() {
        return getDatabase().values().stream().toList();
    }
}
