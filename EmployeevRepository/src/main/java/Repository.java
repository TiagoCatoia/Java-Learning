public interface Repository<T,K> {
    void saveEntity(T t);
    T getEntityById(K k);
}
