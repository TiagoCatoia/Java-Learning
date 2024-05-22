public class GastoSaude extends Gasto {
    private String registroConselho;
    public static final double DEDUCAO_MAX_SAUDE = 1500;

    public GastoSaude(long id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return STR."\nGasto Saude: Registro Conselho= '\{registroConselho} | \{super.toString()}";
    }
}
