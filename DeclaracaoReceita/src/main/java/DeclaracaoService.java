import java.util.stream.Collectors;

public class DeclaracaoService {
    DeclaracaoRepository repository;

    public DeclaracaoService(DeclaracaoRepository repository) {
        this.repository = repository;
    }

    public void iniciarDeclaracao(double ganho, double pago) {
        DeclaracaoSimplificada simplificada = new DeclaracaoSimplificada(1, ganho, pago);
        DeclaracaoCompleta completa = new DeclaracaoCompleta(2, ganho, pago);
        repository.save(simplificada);
        repository.save(completa);
    }

    public String pegarInformacoes() {
        String result = "";
        result += repository
                .findAll()
                .stream()
                .map(Declaracao::toString)
                .collect(Collectors.joining("\n"));
        return result;
    }
}
