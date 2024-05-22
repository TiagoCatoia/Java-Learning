public class GastoService {
    DeclaracaoCompleta declaracao;

    public GastoService(DeclaracaoCompleta declaracao) {
        this.declaracao = declaracao;
    }

    public void iniciaGastoSaude(String descricao, double valor, String cnpj, String registroConselho) {
        declaracao.addGasto(new GastoSaude(GastoRepository.nextId(), descricao, valor, cnpj, registroConselho));

    }

    public void iniciaGastoEducacao(String descricao, double valor, String cnpj, String nomeInstituicao) {
        declaracao.addGasto(new GastoEducacao(GastoRepository.nextId(), descricao, valor, cnpj, nomeInstituicao));
    }
}
