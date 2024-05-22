import java.util.Objects;

public class Gasto implements Entity<Long>{
    private final long id;
    private String descricao;
    private double valor;
    private String cnpj;

    public Gasto(long id, String descricao, double valor, String cnpj) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;
    }

    @Override
    public Long key() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return STR."ID= \{id} | Descricao= '\{descricao} | Valor= \{valor} | CNPJ= '\{cnpj}";
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCnpj() {
        return cnpj;
    }
}
