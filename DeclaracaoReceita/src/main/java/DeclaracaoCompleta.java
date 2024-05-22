import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DeclaracaoCompleta extends Declaracao {
    GastoRepository gastoRepository;

    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
        gastoRepository = new GastoRepository();
    }

    public void addGasto(Gasto gasto) {
        Objects.requireNonNull(gasto, "Gasto não pode ser nulo!");
        if (gastoRepository.findByKey(gasto.key()).isPresent())
            throw new EntityAlreadyExistsException(STR."Gasto com id já cadastrado: \{gasto.getId()}");
        gastoRepository.save(gasto);
    }

    public void removeGasto(Gasto gasto) {
        Objects.requireNonNull(gasto, "Gasto não pode ser nulo!");
        if (gastoRepository.findByKey(gasto.key()).isEmpty())
            throw new NoSuchElementException(STR."ID do Gasto não encontrado: \{gasto.getId()}");
        gastoRepository.delete(gasto);
    }

    public void removeGastoPeloID(long id) {
        if (gastoRepository.findByKey(id).isEmpty())
            throw new NoSuchElementException(STR."ID do Gasto não encontrado: \{id}");
        gastoRepository.deleteByKey(id);
    }

    @Override
    public String toString() {
        double somaGastos = gastoRepository.getDatabase().values().stream().mapToDouble(Gasto::getValor).sum();
        return STR."Declaracao Completa: \{super.toString()}\nSoma dos Gastos: \{somaGastos}\nGastos: \{gastoRepository.getDatabase().toString()}";
    }

    @Override
    public double getDespesaDedutivel() {
        final double gastoSaude = gastoRepository
                .findAll()
                .stream()
                .filter(GastoSaude.class::isInstance)
                .mapToDouble(Gasto::getValor)
                .sum();
        final double gastoEducacao = gastoRepository
                .findAll()
                .stream()
                .filter(GastoEducacao.class::isInstance)
                .mapToDouble(Gasto::getValor)
                .sum();
        return Math.min(GastoSaude.DEDUCAO_MAX_SAUDE, gastoSaude)
                +
                Math.min(GastoEducacao.DEDUCAO_MAX_EDUCA, gastoEducacao);
    }

    @Override
    public double getValorImposto() {
        double ganhoTributavel = getGanhoTributavel();
        double imposto = 0;
        if (ganhoTributavel > 55_976.16) {
            imposto += 0.275 * (ganhoTributavel - 55_976.16);
            ganhoTributavel = 55_976.16;
        }
        if (ganhoTributavel > 45_012.72) {
            imposto += 0.225 * (ganhoTributavel - 45_012.72);
            ganhoTributavel = 45_012.72;
        }
        if (ganhoTributavel > 33_919.92) {
            imposto += 0.15 * (ganhoTributavel - 33_919.92);
            ganhoTributavel = 33_919.92;
        }
        if (ganhoTributavel > 22_847.87) {
            imposto += 0.075 * (ganhoTributavel - 22_847.88);
        }
        return imposto;
    }
}