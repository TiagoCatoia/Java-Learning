import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private final LocalDate payday;
    private final double salary;

    public Paycheck(LocalDate payday, double salary) {
        Objects.requireNonNull(payday, "Payday value must not be null.");
        this.payday = payday;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return STR."\{salary},\{payday}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paycheck paycheck = (Paycheck) o;
        return Double.compare(salary,paycheck.salary) == 0 && Objects.equals(payday,((Paycheck) o).payday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary,payday);
    }

    public LocalDate getPayday() {
        return payday;
    }

    public double getSalary() {
        return salary;
    }
}
