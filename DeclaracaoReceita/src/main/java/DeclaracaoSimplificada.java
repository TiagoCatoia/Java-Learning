import java.util.ArrayList;
import java.util.List;

public class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
    }

    @Override
    public String toString() {
        return STR."Declaracao Simplificada: \{super.toString()}";
    }

    @Override
    public double getValorImposto() {
        return Math.max(0, 0.2 * (getGanhoTributavel() - 22_847.88));
    }
}
