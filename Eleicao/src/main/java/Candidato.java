import java.util.Objects;

public class Candidato {
    private String nomeUrna;
    private String nomeCompleto;
    private int numero;
    private long votos;
    private Cargo cargo;
    // ADICIONAR CARGO

    public Candidato(String nomeUrna, String nomeCompleto, int numero, Cargo cargo) {
        this.nomeUrna = nomeUrna;
        this.nomeCompleto = nomeCompleto;
        this.numero = numero;
        this.cargo = cargo;
    }

    public void receberVoto() {
        votos++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return numero == candidato.numero && cargo == candidato.cargo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, cargo);
    }

    public String getNomeUrna() {
        return nomeUrna;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getNumero() {
        return numero;
    }

    public long getVotos() {
        return votos;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
