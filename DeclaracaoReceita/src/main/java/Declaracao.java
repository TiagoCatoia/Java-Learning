import java.util.Objects;

public abstract class Declaracao implements Entity<Long> {
    private final long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    @Override
    public Long key() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return STR."\nID= \{id} | Ganho Tributavel= \{ganhoTributavel} | Valor Pago= \{valorPago} | Valor Imposto= \{getValorImposto()} | Valor Faltante= \{getValorAPagar()}";
    }

    public final double getValorAPagar() {
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public double getDespesaDedutivel() {
        return 0;
    }

    public abstract double getValorImposto();

    public double getValorPago() {
        return valorPago;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public long getId() {
        return id;
    }

    public void setGanhoTributavel(double ganhoTributavel) {
        this.ganhoTributavel = ganhoTributavel;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
