import java.util.LinkedHashMap;
import java.util.Map;

public class DeclaracaoRepository extends GenericRepository<Long, Declaracao> {
    private static final Map<Long, Declaracao> db = new LinkedHashMap<>();

    @Override
    protected Map<Long, Declaracao> getDatabase() {
        return db;
    }

    @Override
    public void save(Declaracao declaracao) {
        if (db.containsKey(declaracao.getId()))
            throw new EntityAlreadyExistsException(STR."Declaração com id já cadastrado: \{declaracao.getId()}");
        super.save(declaracao);
    }
}
