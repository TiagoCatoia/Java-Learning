import java.util.List;

public class Utilitarioo {
    private Utilitarioo(){};

    public static List<String> carregarCandidatos() {
        return List.of(
                "12345;JOAO SILVA;DEPUTADO_FEDERAL;PARTIDO A",
                "67890;MARIA OLIVEIRA;DEPUTADO_ESTADUAL;PARTIDO B",
                "11112;CARLOS SANTOS;SENADOR;PARTIDO C",
                "33344;ANA PEREIRA;GOVERNADOR;PARTIDO D",
                "55566;LUIS ALMEIDA;PRESIDENTE;PARTIDO E"
        );
    }
}
