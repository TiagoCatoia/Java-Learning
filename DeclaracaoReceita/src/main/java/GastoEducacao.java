import java.util.HashMap;
import java.util.Map;

import static java.lang.StringTemplate.STR;

public class GastoEducacao extends Gasto {
    private String nomeInstituicao;
    public static final double DEDUCAO_MAX_EDUCA = 2000;

    public GastoEducacao(long id, String declaracao, double valor, String cnpj, String nomeInstituicao) {
        super(id, declaracao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return STR."\nGasto Educacao: Instituicao= '\{nomeInstituicao} | \{super.toString()}";
    }
}
