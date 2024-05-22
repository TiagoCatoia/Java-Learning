import java.util.*;

public class Partido {
    private int numero;
    private String nome;
    private final Map<Integer, Candidato> presidente;
    private final Map<Integer, Candidato> governador;
    private final Map<Integer, Candidato> candidatoDeputadoEstadual;
    private final Map<Integer, Candidato> candidatoDeputadoFederal;
    private final Map<Integer, Candidato> candidatoSenado;


    public Partido(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        presidente = new TreeMap<>();
        governador = new TreeMap<>();
        candidatoDeputadoEstadual = new TreeMap<>();
        candidatoDeputadoFederal = new TreeMap<>();
        candidatoSenado = new TreeMap<>();
    }

    public void addCandidato(Candidato candidato) {
        Objects.requireNonNull(candidato, "Candidato não pode ser nulo");
        switch (candidato.getCargo()) {
            case PRESIDENTE -> presidente.put(candidato.getNumero(), candidato);
            case GOVERNADOR -> governador.put(candidato.getNumero(), candidato);
            case DEPUTADO_FEDERAL -> candidatoDeputadoFederal.put(candidato.getNumero(), candidato);
            case DEPUTADO_ESTADUAL -> candidatoDeputadoEstadual.put(candidato.getNumero(), candidato);
            case SENADOR -> candidatoSenado.put(candidato.getNumero(), candidato);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return numero == partido.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    public Optional<Candidato> getCandidato(Cargo cargo, int numCandidato) {
        Candidato candidato = null;
        switch (cargo) {
            case PRESIDENTE -> candidato = presidente.get(numCandidato);
            case GOVERNADOR -> candidato = governador.get(numCandidato);
            case DEPUTADO_FEDERAL -> candidato = candidatoDeputadoFederal.get(numCandidato);
            case DEPUTADO_ESTADUAL -> candidato = candidatoDeputadoEstadual.get(numCandidato);
            case SENADOR -> candidato = candidatoSenado.get(numCandidato);
        }
        return Optional.ofNullable(candidato);
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Map<Integer, Candidato> getCandidatosPorCargo(Cargo cargo) {
        return switch (cargo) {
            case PRESIDENTE -> {
                yield presidente;
            }
            case GOVERNADOR -> {
                yield governador;
            }
            case DEPUTADO_FEDERAL -> {
                yield candidatoDeputadoFederal;
            }
            case DEPUTADO_ESTADUAL -> {
                yield candidatoDeputadoEstadual;
            }
            case SENADOR -> {
                yield candidatoSenado;
            }
        };
    }
}